package com.galleryview.com.gv;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {
	public Dashboard(ChromeDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			
//			WebElement  
		}catch(Exception e) {
			System.out.print("System check error" +e);
		}
	}

}
