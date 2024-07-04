package com.galleryview.com.gv;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClientNotes {

	public ClientNotes (ChromeDriver driver) {
		
		try {
			
			new SidebarClient(driver);

			/*Adding the Notes for the Selected Client*/
			
			//Adding Notes
			WebElement addNote = driver.findElement(By.xpath("//span[contains(text(), 'ADD NOTE')]"));
			addNote.click();
			
			Thread.sleep(1500);  		//Wait for 1.5 second
			//Enter Title and Content
			WebElement title = driver.findElement(By.id("title"));
			title.sendKeys("This is for the testing purpose.");
			
			Thread.sleep(1500);
			WebElement content = driver.findElement(By.xpath("//div[@aria-label='rdw-editor']"));
			content.click(); 
			Thread.sleep(1500);			//Wait for 1.5 Second
			content.sendKeys("Hello User! Congratulations");
			
			//Save Note
			Thread.sleep(1500);  		//Wait for 1.5 Second
			WebElement saveNote = driver.findElement(By.xpath("//button[@type='submit']"));
			saveNote.click();
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




