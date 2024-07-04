package com.galleryview.com.gv;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SidebarOpen {
	public SidebarOpen(ChromeDriver driver) {
try {
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			//SideBar
			WebElement sideNav = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/section/section/header/section/div/div/div[1]/h4/header/span")));
			sideNav.click();
			
		}catch(Exception e) {
			System.out.print("System Error");
		}
	}
}
