package com.galleryview.com.gv.SuperAdminuser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminSupport {
	public AdminSupport(ChromeDriver driver) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			
			new Adminlogin(driver);
			
			//Support Section
			WebElement support = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='SUPPORT']")));
			support.click();
			
			WebElement id = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[@class='ant-table-cell']/span/u)[2]")));
			id.click();
			
			//Status Checking
			WebElement status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Open')]")));
			String getStatus = status.getText();
			//Adding a Comment
			WebElement comment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'public-DraftStyleDefault-block')]")));
			System.out.print("Check" + getStatus + '\n');
			if("Open".equalsIgnoreCase(getStatus)) {
				
				comment.click();
				comment.sendKeys("Checking");
			} else {
				System.out.print("Status is not Open");
			}
			
			//Marked as Closed
			WebElement mark = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='MARK AS CLOSED']")));
			mark.click();
			
			//OK Button
			WebElement okBTN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='OK']")));
			okBTN.click();
			
			//Cancel the screen
			WebElement cancelBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='CANCEL']")));
			cancelBtn.click();
			
		}catch(Exception e) {
			System.out.print("System Error::" +e);
		}
	}

}
