package com.galleryview.com.gv;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClientAddress {
	
	public ClientAddress(ChromeDriver driver) {
		
		try {
			new SidebarClient(driver);
			/*Adding the Address for the Selected Client*/
			
			WebElement addAddress = driver.findElement(By.xpath("//span[contains(text(), 'ADD ADDRESS')]"));
			addAddress.click();
			Thread.sleep(2000);
			
			//NickName 
			WebElement nickName = driver.findElement(By.id("nickName"));
			nickName.sendKeys("Parios");
			
			//Open Status
			WebElement status = driver.findElement(By.id("status"));
			status.click();
			Thread.sleep(2000); 		//Wait for 2 Second
			
			//Choose Status
			WebElement selectStatus = driver.findElement(By.xpath("//div[contains(@title, 'Delivery')]/div"));
			selectStatus.click();
			Thread.sleep(2000);			//Wait for 2 Second
			
			//Street
			WebElement street = driver.findElement(By.id("street"));
			street.sendKeys("123, Caen");
			Thread.sleep(2000);			//Wait for 2 Second
			
			//County
			WebElement county = driver.findElement(By.id("country"));
			county.sendKeys("USA");
			Thread.sleep(2000);			//Wait for 2 Second
			
			//PostCode
			WebElement postCode = driver.findElement(By.id("postCode"));
			postCode.sendKeys("12343");
			Thread.sleep(2000);			//Wait for 2 Second
			
			//Save Address
			WebElement saveAddress = driver.findElement(By.xpath("//span[contains(text(), 'SAVE ADDRESS')]"));
			saveAddress.click();
			Thread.sleep(4000);			//Wait for 4 Second
		
		
		}catch (NoSuchElementException e) {
	        System.out.println("Element not found: " + e.getMessage());
	        e.printStackTrace();
	    } catch (InterruptedException e) {
	        System.out.println("Element not found: " + e.getMessage());
			e.printStackTrace();
		}
	}
}