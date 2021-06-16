package com.selenium.basics;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class RediffFilling extends Base {
	

	
		public static void main(String[] args) {

			openBrowser("Chrome");
			
			driver.get("https://register.rediff.com/register/register.php");
			
			//Name Field
			driver.findElement(By.xpath("//*[starts-with(@name, 'name')]")).sendKeys("Ram");
			
			//Password Field
			driver.findElement(By.xpath("//*[starts-with(@name,'passwd')]")).sendKeys("krishna");
			
			//Date of Birth
			new Select(driver.findElement(By.xpath("//*[starts-with(@name,'DOB_Day')]"))).selectByVisibleText("02");
			new Select(driver.findElement(By.xpath("//*[starts-with(@name,'DOB_Month')]"))).selectByVisibleText("JUN");
			new Select(driver.findElement(By.xpath("//*[starts-with(@name, 'DOB_Year')]"))).selectByValue("1999");
			
			
			//Country
			new Select(driver.findElement(By.id("country"))).selectByVisibleText("India");
			
			
			//CITY
			driver.findElement(By.xpath("//*[starts-with(@name, 'city')]/option[text()='Hyderabad']")).click();
			
			//GENDER
			driver.findElement(By.xpath("//*[starts-with(@name, 'gender') and @value='m']")).click();
			
			WebElement altemail = driver.findElement(By.xpath("//*[starts-with(@name, 'altemail')]"));
			
			//CheckBox
			WebElement checkbox = driver.findElement(By.xpath("//*[starts-with(@name, 'chk_altemail')]"));
			if(!checkbox.isSelected()) {
				checkbox.click();
			} else {
				System.out.println("Checkbox already selected");
			}
			
			//Verify that the altemail field disappears
			if(!altemail.isDisplayed()) {
				System.out.println("Alt Email Disappeared");
			}
			
			//Click on Button
			driver.findElement(By.id("Register")).click();
			
			String expected = "ID cannot be blank";
			
			//Javascript popups - There is no HTML code
			
			Alert myalert = driver.switchTo().alert();
			
			String actual = myalert.getText(); //Get the text from the Alert
			
			System.out.println("Text on Alert box is: \n"+actual);
			
			if(actual.contains(expected)) {
				System.out.println("Test Passed");
				myalert.accept(); //OK button
				//myalert.dismiss(); //Cancel
				//myalert.sendKeys("Some text"); //If alert has a text box
			} else {
				System.out.println("Test Failed");
			}
			
		}

	}
	
	
	
	

