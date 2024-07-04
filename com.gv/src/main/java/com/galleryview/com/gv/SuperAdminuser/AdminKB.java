package com.galleryview.com.gv.SuperAdminuser;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminKB {
	public AdminKB(ChromeDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		ConfigReaders config = new ConfigReaders();		
		String category = config.getSuperAdmin("categoryname");
        String subcategory = config.getSuperAdmin("subcategory");
		
		//KB Section
		WebElement kb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='KB']")));
		kb.click();
		
		try {
			//Add KB
			WebElement addbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='ADD/EDIT/DELETE']")));
			addbtn.click();
			
			//Adding Category
			WebElement addCat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Category Name']")));
			addCat.sendKeys(category);
			WebElement addBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='ADD']")));
			addBtn.click();
			
			WebElement selectCat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'ant-select-single')])[2]")));
			selectCat.click();
		
			String createdCategory = "//div[contains(@class, 'ant-select-item-option') and text()='" + category + "']";
			WebElement chooseCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(createdCategory)));
			chooseCategory.click();
			
			//Sub Category Name
			WebElement subCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Sub-category Name']")));
			subCategory.sendKeys(subcategory);
			
			//Add sub category
			WebElement addBTN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='ADD'])[2]")));
			addBTN.click();
			
		}catch(Exception e) {
			System.out.print("Exception error: " + e);
		}
	}

}
