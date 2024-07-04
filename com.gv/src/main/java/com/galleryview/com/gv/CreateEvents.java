package com.galleryview.com.gv;

import java.time.Duration;
//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateEvents {
public CreateEvents(ChromeDriver driver) {
	
	try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			new SidebarOpen(driver);
			
			WebElement galCalendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Gallery Calendar']")));
			galCalendar.click();
			
			WebElement createBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'ant-btn-default')]/span")));
			createBtn.click();
			
			Thread.sleep(3000);
			WebElement eventType = driver.findElement(By.xpath("//input[@id='typeId']"));
			eventType.click();
			
			WebElement selectType = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'ant-select-item-option')]/div)[1]")));
			selectType.click();
			
			// Apply condition for +5 days from the current date
			LocalDateTime currentDate = LocalDateTime.now();									//Current Date
			LocalDateTime futureDate = currentDate.plusDays(5);									//Future Date
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY HH:mm");		//Date Format
						
			String formattedFutureDate = futureDate.format(formatter);
			System.out.println('\n' + "Future Date: " + formattedFutureDate + '\n');
			
			//Select the Date and Time
			WebElement selectTime = driver.findElement(By.xpath("//input[@id='startDate']"));
			selectTime.sendKeys(formattedFutureDate);
			selectTime.sendKeys(Keys.ENTER);
			
			//Duration
			WebElement duration = driver.findElement(By.xpath("//input[@id='duration']"));
			duration.click();
			
			WebElement selectDur = driver.findElement(By.xpath("//div[2]/div/div/div/div[3]/div"));
			boolean select = selectDur.isEnabled();
			System.out.print("Select:: " +select + '\n');
			selectDur.click();
			
		}
			catch(Exception e) 
			{
				System.out.print("System Error");
			}
}
}