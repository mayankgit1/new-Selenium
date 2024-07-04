package com.galleryview.com.gv.SuperAdminuser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminComponents {
	public AdminComponents(ChromeDriver driver) {
		
		try {
			WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			 String[] components = {"Prospect", "Support", "KB", "Feedback", "Feature Requests", "Notification", "Products"};
			for(int i=0; i<components.length; i++) {
				String str = "";
				switch(components[i]) {
				case "Prospect":
					str = "//span[text()='PROSPECTS']";
					break;
					
				case "Support":
					str = "//span[text()='SUPPORT']";
					break;
				
				case "KB":
					str = "//span[text()='KB']";
					break;
					
				case "Feedback":
					str = "//span[text()='FEEDBACK']";
					break;
					
				case "Feature Requests":
					str = "//span[text()='FEATURE REQUESTS']";
					break;
					
				case "Notification":
					str = "(//button[contains(@class, 'ant-btn ant-btn-primary css-ak1qn3')])[7]";
					break;
					
				case "Products":
					str = "//span[text()='PRODUCTS']";
					break;
				}
			
				//Prospects Verify and Click
				WebElement prospect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(str)));
				if(prospect.isDisplayed()) {
					prospect.click();
					System.out.print("Successfully Verified!!"+components[i] + '\n');
				}else {
					System.out.print("Prospect Not Found");
				}
				
			}
		
		}catch(Exception e) {
			System.out.print("System check: " +e);
		}
	}
}