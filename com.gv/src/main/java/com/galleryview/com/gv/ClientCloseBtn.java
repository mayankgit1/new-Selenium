package com.galleryview.com.gv;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientCloseBtn {
	public ClientCloseBtn(ChromeDriver driver) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			WebElement closeClient = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[(text()='CLOSE CLIENT')])[4]")));
			closeClient.click();
			
		}catch(Exception e) {
			System.out.print("Error Found");
		}finally {
			driver.quit();
		}
	}

}
