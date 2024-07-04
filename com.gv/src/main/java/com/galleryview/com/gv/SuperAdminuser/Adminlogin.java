package com.galleryview.com.gv.SuperAdminuser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Adminlogin {
	public Adminlogin(ChromeDriver driver) {
		
	
		ConfigReaders config = new ConfigReaders();    
    	try {
        	
    		String url = config.getSuperAdmin("admin_url");
        	String galleryPinValue = config.getSuperAdmin("admin_gallpin");
            String emailValue = config.getSuperAdmin("admin_username");
            String passwordValue = config.getSuperAdmin("admin_password");
            String factorauth = config.getSuperAdmin("2FA");
        	
            if (url == null || galleryPinValue == null || emailValue == null || passwordValue == null) {
                throw new IllegalArgumentException("One or more configuration properties are missing.");
            }
            
            driver.manage().window().maximize();

            // Navigate to the login page
            driver.get(url);
           
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 
		// Find login elements
        WebElement gallerypin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id, 'gallerypin')]")));
        gallerypin.sendKeys(galleryPinValue);
        
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id, 'email')]")));
        email.sendKeys(emailValue);
        
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id, 'password')]")));
        password.sendKeys(passwordValue);
		
        WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@type, 'submit')]")));
        login.click();

        // Wait for 2FA code input field to appear
        Thread.sleep(5000);
        WebElement code = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ant-form-item-control-input-content')]//input")));

        // Enter the 2FA code and submit
        code.click();
        code.sendKeys(factorauth);
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@type,'submit')]")));
        submit.click();
    	}catch(Exception e) {
    		System.out.print("system Check::" + e);
    	}
	}
}