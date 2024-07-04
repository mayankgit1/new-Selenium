package com.galleryview.com.gv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SidebarClient {
	public SidebarClient(ChromeDriver driver) {
		
		try {
					// Open Side bar
					new SidebarOpen(driver);
				    
				    //Open Client
				    WebElement OpenClient = driver.findElement(By.xpath("/html/body/div[1]/section/section/header/section/section/div/div[3]/div/div/div[2]/ul/li[2]/span/div"));
				    OpenClient.isDisplayed();
				    OpenClient.click();
				    Thread.sleep(4000);			//Wait for 4 Second
				    
				    //Select Client
				    WebElement selectClient = driver.findElement(By.xpath("//*[@id=\"main-layout\"]/div/div[2]/div[3]/div/div/div/div/div/div[1]/div[2]/table/tbody/tr[2]/td[3]/span"));
				    selectClient.click();
				    Thread.sleep(4000);			//Wait for 4 Second

			} catch(Exception e) {
				System.out.print("Client Element not found");
			}
		}
}
