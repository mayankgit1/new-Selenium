package com.galleryview.com.gv.SuperAdminuser;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FeatureRequestDeletion {
	public FeatureRequestDeletion(ChromeDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			
			//Feature Request button
			WebElement featurereqBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='FEATURE REQUESTS']")));
			featurereqBtn.click();
			
			//Category Creation
			WebElement categoryCreates = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='CATEGORY']")));
			categoryCreates.click();
			
			WebElement dropdownElement = driver.findElement(By.xpath("//div[@class='ant-row css-1el9s8e']"));
			Select dropdown = new Select(dropdownElement);
			
//			String[] optionsValues = new String[optionsValues.length];
			List<WebElement> options = dropdown.getOptions();
			
		}catch(Exception e) {
			System.out.print("System errir" +e);
		}
	}
}