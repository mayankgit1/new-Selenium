package com.galleryview.com.gv;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImportArtwork {

	public ImportArtwork(ChromeDriver driver) {
		try {

			//Side-bar Open
			Thread.sleep(5000);
			WebElement Sidebar = driver.findElement(By.xpath("/html/body/div[1]/section/section/header/section/div/div/div[1]/h4/header/span"));
			Sidebar.click();
			
			//Open Manage Artwork/Products
			Thread.sleep(5000);
			WebElement artProduct = driver.findElement(By.xpath("//div[contains(text(), 'Manage Artwork/Products')]"));
			if(artProduct.isDisplayed()) {
			artProduct.click();
			}else {
				System.out.print("Element not found");
			}
			
			//Select File to Import
			Thread.sleep(2500);
			WebElement file = driver.findElement(By.xpath("//input[contains(@type, 'file')]"));
			file.sendKeys("C:\\Users\\Cloud Analogy\\Downloads\\Excel Sheet\\New Art.csv");

			//Import the selected file
			Thread.sleep(1000);
			WebElement importFile = driver.findElement(By.xpath("//span[contains(text(), 'IMPORT')]"));
				importFile.click();	
			
			
		} catch (NoSuchElementException e) {
	        System.out.println("Element not found: " + e.getMessage());
	        e.printStackTrace();
	    } catch (WebDriverException e) {
	        System.out.println("WebDriver exception occurred: " + e.getMessage());
	        e.printStackTrace();
	    } catch (InterruptedException e) {
	        System.out.println("Thread interrupted: " + e.getMessage());
	        e.printStackTrace();
	}
}
}