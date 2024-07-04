package com.galleryview.com.gv;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageSubscription {
	public ManageSubscription(ChromeDriver driver) {
		
		try {
			new SideBarAdmin(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			//Click to Manage Subscription Button
			WebElement subcriptionBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Manage Subscription')]")));
			subcriptionBtn.click();
			
			//Verify the Invoice Delivery Address
			WebElement verifyAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(), 'developer+finforce@gallery-view.co.uk')]")));
			System.out.print("Veify Address" + verifyAddress);
			
			// Get the text of the address element
	        String actualAddress = verifyAddress.getText();
			
			//Check if value matches the expected value
			String expectedValue = "developer+finforce@gallery-view.co.uk";
			 if (actualAddress.equals(expectedValue)) 
			 {
				 	//Edit Subscription Button
					WebElement editBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'EDIT SUBSCRIPTION')]")));
					editBtn.click();
		            System.out.println("Element value is correct: " + actualAddress);
		     } 
			 else 
			 {
		            System.out.println("Element value is incorrect. Actual value: " + actualAddress + ", Expected value: " + expectedValue);
		     }
			
		}catch(Exception e) {
			System.out.print("Element Error");
		}
	}
}
