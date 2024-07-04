package com.galleryview.com.gv.SuperAdminuser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.galleryview.com.gv.SuperAdminuser.ConfigReaders;

public class FeatureRequestCreation {
	public FeatureRequestCreation(ChromeDriver driver) {
		
		ConfigReaders config = new ConfigReaders();
		
		String FRcategory = config.getSuperAdmin("FRcategory");
		String StatusValue = config.getSuperAdmin("Statusvalue");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			
			//Feature Request button
			WebElement featurereqBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='FEATURE REQUESTS']")));
			featurereqBtn.click();
			
			
			//Category Creation
			WebElement categoryCreates = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='CATEGORY']")));
			categoryCreates.click();
			
			// Locate the status_value input field
            WebElement statusValueInput = driver.findElement(By.id("status_value"));

            // Check if the status_value input field is blank
            if (statusValueInput.getAttribute("value").isEmpty()) {
                
                statusValueInput.sendKeys(FRcategory);
                statusValueInput.sendKeys(Keys.ENTER);
            }

			WebElement closeBTN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='CLOSE']")));
			closeBTN.click();
			
//            Creating a Status on Feature Request
			WebElement status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='STATUS']")));
			status.click();
			
			WebElement statusValue = driver.findElement(By.id("status_value"));
			 if (statusValue.getAttribute("value").isEmpty()) {
				 statusValue.sendKeys(StatusValue);
				 statusValue.sendKeys(Keys.ENTER);
			  }
			 
			WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='CLOSE']")));
			close.click();
            
		}catch(Exception e) {
			System.out.print(false);
		}
	}
}
