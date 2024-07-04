package com.galleryview.com.gv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SidebarTasks {

	public SidebarTasks(ChromeDriver driver) {

		try {
		//Side-bar Open
		new SidebarOpen(driver);
		
		//Open Task using Side-bar
		Thread.sleep(2000);
	    WebElement Task = driver.findElement(By.xpath("//li[5]/span/div"));
	    Task.click();            
		
	    //Click to Create Task
	    Thread.sleep(2000);
	    WebElement CreateTask = driver.findElement(By.xpath("//main/div[1]/div[2]/button/span"));
	    CreateTask.click();
	}
		catch(Exception e) {
			System.out.print("Element not found");
		}
	}
}
