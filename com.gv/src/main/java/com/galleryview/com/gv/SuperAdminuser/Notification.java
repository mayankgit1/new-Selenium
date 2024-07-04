package com.galleryview.com.gv.SuperAdminuser;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Notification {
	public Notification (ChromeDriver driver) {
		try {
			
//			Notification Button
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement notifyBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='ant-btn ant-btn-primary css-ak1qn3'])[7]")));
			if(notifyBtn.isDisplayed()) {
				notifyBtn.click();
			}
			
//			Add New Notification Button
			WebElement addNew = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='ADD NEW NOTIFICATION ']")));
			addNew.click();
			
//			Create New Notification
			WebElement startDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='notificationform_startDate']")));
			if(startDate.isDisplayed()) {
			startDate.click();
			}
			
//			Apply Condition When the Start Date Select For Today 
			WebElement todaySelectDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='ant-picker-today-btn']")));
			String value = "";
			if(todaySelectDate !=null) {
			todaySelectDate.click();
			
			WebElement selectDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='notificationform_startDate']")));
			value = selectDate.getAttribute("value");
			System.out.print("Select Date::" +value + '\n');
			
			}else {
				System.out.println("Element not found");
			}
			
//			Apply condition for +5 days from the current date to Start Date for Notification Banner
/*			LocalDate currentDate = LocalDate.now();																						//Current Date
			LocalDate futureDate = currentDate.plusDays(5);																					//Future Date
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");														//Date Format
			
		    String formattedFutureDate = futureDate.format(formatter);
			System.out.println('\n' + "Future Date: " + formattedFutureDate + '\n');
			
			WebElement rndmStartDate = driver.findElement(By.xpath("//input[@id='notificationform_startDate']"));
			System.out.print("Start Date" + rndmStartDate);
			rndmStartDate.sendKeys(formattedFutureDate);
			rndmStartDate.sendKeys(Keys.ENTER);*/
			
//			Select Start Time for Banner
			WebElement openStartTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notificationform_startTime")));
			if(openStartTime.isDisplayed()) {
				openStartTime.click();
			}
			WebElement selectStartTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ant-picker-now-btn")));
			if(selectStartTime.isDisplayed()) {
				selectStartTime.click();
				System.out.print("Today Time:::" +selectStartTime + '\n');
			}
			
//			Apply condition for +5 days from the current date to End Date for Notification Banner
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			LocalDate todayDate = LocalDate.parse(value, format);	
			System.out.print("Today Date Value:::" +todayDate + '\n');								//Current Date
			
			LocalDate futureDate = todayDate.plusDays(5);	
            System.out.println("New LocalDate: " + futureDate + '\n');		
             
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");		//Date Format
		    String formattedFutureDate = futureDate.format(formatter);
			System.out.println('\n' + "Future Date: " + formattedFutureDate + '\n');
			
//			Enter the Date
			WebElement rndmEndDate = driver.findElement(By.id("notificationform_endDate"));
			rndmEndDate.click();
			rndmEndDate.sendKeys(formattedFutureDate);
			rndmEndDate.sendKeys(Keys.ENTER);
			System.out.print("End Date" + rndmEndDate + '\n');
			
//			Select the End Time
			WebElement openEndTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notificationform_endTime")));
			if(openEndTime.isDisplayed() && openEndTime!=null) {
				openEndTime.click();
			}
			WebElement selectendTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='ant-picker-now-btn'])[2]")));
			selectendTime.click();
			
//			Banner Uploading
			WebElement filesUpload = driver.findElement(By.id("notificationform_upload"));
			filesUpload.sendKeys("C:\\Users\\Cloud Analogy\\Downloads\\banner.png");
			
			Thread.sleep(2500);
//			Save the Banner details.
			WebElement saveBtn = driver.findElement(By.xpath("//span[text()='SAVE']"));
			saveBtn.click();
			
//			Close Notification Page
			WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("css-1y0bi7m")));
			closeBtn.click();
			
		}catch(Exception e) {
			System.out.print("System check error" +e);
		}
	}
}