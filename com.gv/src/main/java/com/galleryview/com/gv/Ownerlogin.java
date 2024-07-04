package com.galleryview.com.gv;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ownerlogin {
	
public Ownerlogin(ChromeDriver driver)  {
	
    	ConfigReader config = new ConfigReader();    
    	try {
        	
    		String url = config.getProperty("url");
        	String galleryPinValue = config.getProperty("gallerypin");
            String emailValue = config.getProperty("username");
            String passwordValue = config.getProperty("password");
        	
            if (url == null || galleryPinValue == null || emailValue == null || passwordValue == null) {
                throw new IllegalArgumentException("One or more configuration properties are missing.");
            }
            
            driver.manage().window().maximize();

            // Navigate to the login page
            driver.get(url);
           
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            // Find login elements
            WebElement gallerypin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id, 'gallerypin')]")));
            WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id, 'email')]")));
            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id, 'password')]")));

            // Fill the Login details and submit
            gallerypin.sendKeys(galleryPinValue);
            email.sendKeys(emailValue);
            password.sendKeys(passwordValue);
            WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@type, 'submit')]")));
            login.click();

            // Wait for 2FA code input field to appear
            Thread.sleep(5000);
            WebElement code = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'ant-form-item-control-input-content')]//input")));

            // Enter the 2FA code and submit
            code.click();
            code.sendKeys("14321432");
            WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@type,'submit')]")));
            submit.click();
            
            //Fetch Token
            String token = (String) ((JavascriptExecutor) driver).executeScript("return localStorage.getItem('token');");
            System.out.print("Token::" + token + '\n');

         // Store the token in a file
            try (PrintWriter out = new PrintWriter(new FileWriter("token.txt"))) {
                out.println(token);
            } catch (IOException e) {
				e.printStackTrace();
			} 
           
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
            e.printStackTrace();
        } catch (WebDriverException e) {
            System.out.println("WebDriver exception occurred: " + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e1) {
			e1.printStackTrace();
		}
    
	} 
      
 }