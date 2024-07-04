package com.galleryview.com.gv.SuperAdminuser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.galleryview.com.gv.ConfigReader;

public class AdminProductCreation {
	public AdminProductCreation(ChromeDriver driver) {

		
		ConfigReader config = new ConfigReader();
		try {
        	String prod = config.getProduct("proddesc");
            String subhead = config.getProduct("subhead");
            String unitprice = config.getProduct("unitprice");
            
            if (prod == null || subhead == null || unitprice == null) {
                throw new IllegalArgumentException("One or more configuration properties are missing.");
            }
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            //Product/Service Description
			WebElement prodDesc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='description']")));
			if(prodDesc.isDisplayed()) {
				prodDesc.sendKeys(prod);
			}else {
				System.out.print("Not Correct"+ prodDesc);
			}
			
			//Product/Service Sub Header
			WebElement shead = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='subHeader']")));
			shead.sendKeys(subhead);
			
			//Unit Monthly Price
			WebElement uprice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='price']")));
			uprice.sendKeys(unitprice);
			
			
			//Xero Account
			WebElement xeroAccount = driver.findElement(By.xpath("//input[@id='accountId']"));
			xeroAccount.click();
						
			// Your logic after scrolling completes
            System.out.println("Scrolled until element 'GV training' was not found.");
					
			 // Scroll to make the account selection visible
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement selectAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='GV Training']")));
            js.executeScript("arguments[0].scrollIntoView(true);", selectAccount);

            if (selectAccount.isDisplayed()) {
                selectAccount.click();
            } else {
                System.out.print("Not found" + selectAccount);
            }
			
            //Xero Tax Rate
            WebElement taxRate = driver.findElement(By.xpath("//input[@id='taxRate']"));
            taxRate.click();
            
            WebElement selectRate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'ant-select-item-option')]/div)[12]")));
            if(selectRate.isDisplayed()) {
            	selectRate.click();
            }
            
            //Category
            WebElement category = driver.findElement(By.xpath("//input[@id='category']"));
            category.click();
            
            WebElement selectCate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'ant-select-item-option')])[46]")));
            if(selectCate.isDisplayed()) {
            	selectCate.click();
            }else {
            	System.out.print("Not found");
            }
            
            WebElement enable = driver.findElement(By.xpath("//input[@id='status']"));
            enable.click();
            
            WebElement addprod = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='ADD PRODUCT']")));
            addprod.click();
            
            WebElement close = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='CLOSE']")));
            close.click();
            
		}catch(Exception e) {
			System.out.print("System Check:" + e);
		}
	}

}