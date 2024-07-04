package com.galleryview.com.gv;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClientSendEmail {

	public ClientSendEmail(ChromeDriver driver) {
		
		try {
			new SidebarClient(driver);
		
		/*Sending Email for the Selected Client*/
		
		//Click to Send Email 
		WebElement sendEmail = driver.findElement(By.xpath("//span[contains(text(), 'SEND EMAIL')]"));
		sendEmail.click();
		Thread.sleep(2000);			//Wait for 2 Second
		
		//Adding Subject
		WebElement subject = driver.findElement(By.id("Subject"));
		subject.sendKeys("Test Email");
		Thread.sleep(2000);			//Wait for 2 Second
		
		//Insert Artwork 
		WebElement insertArtwork = driver.findElement(By.xpath("//span[contains(text(), 'INSERT ARTWORK')]"));
		insertArtwork.click();
		Thread.sleep(3000);			//Wait for 3 Second
		
		//SELECT PRODUCT
		WebElement product = driver.findElement(By.xpath("//label[contains(@class, 'ant-checkbox-wrapper')]/span/input[contains(@value, '1277e752-ac51-4e5c-9059-3a526b1a07d9')]"));			
//		if(product.isSelected()) {				// ADDED CONDITION IF ARTWORK IS ALREADY RESERVED CHOOSE ANOTHER ONE
//			System.out.print("This Artwork is already Reserved");
			product.click();
//		}else {
//			WebElement secProduct = driver.findElement(By.xpath("//div/div[2]/div/div/div[1]/div/div[1]/div/label/span/input"));
//			secProduct.click();
		Thread.sleep(2000);			//Wait for 2 Second
//			}	

		WebElement addTOEmail = driver.findElement(By.xpath("//span[contains(text(), 'ADD TO EMAIL')]"));
		addTOEmail.click();
		Thread.sleep(4000);			//Wait for 2 Second
		
		//Send Email
		WebElement send = driver.findElement(By.xpath("//span[(text() = 'SEND')]"));
		send.click();
		
	}catch (NoSuchElementException e) {
        System.out.println("Element not found: " + e.getMessage());
        e.printStackTrace();
    } catch (InterruptedException e) {
        System.out.println("Element not found: " + e.getMessage());
		e.printStackTrace();
	}
}
}