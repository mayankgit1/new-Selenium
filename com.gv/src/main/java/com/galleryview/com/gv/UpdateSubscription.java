package com.galleryview.com.gv;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UpdateSubscription {
	public UpdateSubscription(ChromeDriver driver){
		
		try {
			new ManageSubscription(driver);
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			 //Additional Consultant License
			 WebElement addConsult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 'ant-input-number-input-wrap')]/input)[1]")));
			 addConsult.sendKeys("1");
			 WebElement addBtn1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='ADD >>'])[1]")));
			 addBtn1.click();
			 
			 //Gallery Location License
			 WebElement addLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 'ant-input-number-input-wrap')]/input)[2]")));
			 addLocation.sendKeys("1");
			 WebElement addBtn2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='ADD >>'])[2]")));
			 addBtn2.click();
			 
			//WordPress/WooCommerce Integration
			 WebElement addIntegration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 'ant-input-number-input-wrap')]/input)[3]")));
			 addIntegration.sendKeys("1");
			 WebElement addBtn3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='ADD >>'])[3]")));
			 addBtn3.click();
			 
			//Premium Platform Support
			 WebElement addSupport = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 'ant-input-number-input-wrap')]/input)[4]")));
			 addSupport.sendKeys("1");
			 WebElement addBtn4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='ADD >>'])[4]")));
			 addBtn4.click();
			 
			//IT Support & Security Package
			 WebElement addITPackage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 'ant-input-number-input-wrap')]/input)[5]")));
			 addITPackage.sendKeys("1");
			 WebElement addBtn5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='ADD >>'])[5]")));
			 addBtn5.click();
			 
			 //Verify the New Money Subscription Total
			 WebElement newMontlyTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='New Monthly Subscription Total:']/following-sibling::*")));
			 newMontlyTotal.isDisplayed();
			 
			 System.out.print("Verify the New Monthly Total" + newMontlyTotal + '\n');
			 			 
			 //Get the New Monthly Subscription Total Text
			 String newMonthlyValue = newMontlyTotal.getText();
			 System.out.print("New Monthly Subscription Total: " + newMonthlyValue + '\n');
			 
			//Update Subscription Button
			 WebElement updateBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='UPDATE SUBSCRIPTION']")));
			 updateBtn.click();
			 
			 //Compare the Confirm Subscription Page Monthly Subscription Total:
			 WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Monthly Subscription Total:'])[2]/../following-sibling::*/h5")));
			 amount.isDisplayed();
			 
			 String amountText = amount.getText();
			 System.out.print("Amount Text is : " + amountText + '\n');			 
			 
			 if(newMonthlyValue.equals(amountText)) {
				 System.out.print("Subscription Value matched successfully!! " + '\n');
				 
				 
			//Confirm Page Update Subscription Button
			 WebElement confirmBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='UPDATE SUBSCRIPTION']")));
			 confirmBtn.click();
			}
			 else
			 {
				 WebElement cancelBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='CANCEL']")));
				 cancelBtn.click();
				 System.out.print("Subscription Value not matched");
			 }
			 
			 //Close Subscription Page
			 WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='CLOSE']")));
			 closeBtn.click();
			 
			 //Close Subscription Account Page
			 WebElement closeAccountBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='CLOSE']")));
			 closeAccountBtn.clear();
			 
		}catch (Exception e) {
			System.out.print("Elemet Error not correct");
		}
	}

}
