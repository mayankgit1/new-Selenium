package com.galleryview.com.gv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClientAddTask {
	public ClientAddTask(ChromeDriver driver) {
		
		try {

			new SidebarClient(driver);
			// Adding the Task
			WebElement addTask = driver.findElement(By.xpath("//span[text() = 'ADD TASK']"));
			addTask.click();
			Thread.sleep(3000);				//Wait for 4 Second
			new CreateTask(driver);			//Task Class recall
			
		} catch(Exception e) {
			System.out.print("Element not found");
		}
	}
}
