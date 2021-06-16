package com.selenium.basics;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class RedifMoneyExample extends Base {





	public static void main(String[] args) {
		
		openBrowser("Chrome");
		
		driver.get("http://money.rediff.com/gainers");
		
		//1. Get the Company Names from the Table
		//1.1 - Get the Table in List
		//1.2 - Get Company names from the List
		
		List<WebElement> companynames = driver.findElements(By.xpath("//table[@class='dataTable']//a"));
		
	for(int i=0; i<=10; i++) {
		System.out.println(companynames.get(i).getText());
	}
		
		System.out.println(companynames.size());
		
		//2. Get the Current Price
		
		List<WebElement> prices = driver.findElements(By.xpath("//table[@class='dataTable']//td[4]"));
		
		

		//3. Compare if the Current Price is > 100 and print Company Name and Price together
		
		for (WebElement price : prices) {
			
			String eachprice = price.getText();
			
			eachprice = eachprice.replace(",", ""); //replace all , to blank
			
			double pricedouble = Double.parseDouble(eachprice);
			
			if(pricedouble>100.00) {
				int index = prices.indexOf(price);
				System.out.print(companynames.get(index).getText());
				System.out.println(" : "+pricedouble);
			}		
		}	
	
	}

}
