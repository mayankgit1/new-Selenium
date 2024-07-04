package com.galleryview.com.gv;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateLeads {
	public CreateLeads(ChromeDriver driver) {
		
		try {
//			new SidebarClient(driver);
//			new CreateLeadButton(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
		
		  	//Opt the Client
			WebElement optClient = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='clientId']")));
			boolean clientID = optClient.isSelected();			
			System.out.print("IsSelected:: " + clientID);

			WebElement selectClient = driver.findElement(By.xpath("(//span[contains(@class,'ant-select-selection-item')])[1]"));
		    if(!selectClient.isSelected()) {
		    	System.out.print('\n' + "Client has already value" + '\n');
		    }
		    
			//Verify the Consultant
			WebElement consult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ownerId']")));
			consult.isSelected();
			boolean verifyConsult = true;
			System.out.print(verifyConsult);
			if(verifyConsult) {
				System.out.print('\n' + "Element is present22" + verifyConsult);
			}
			else {
			System.out.print("Element not present");
			}

			//Select Location
			WebElement location = driver.findElement(By.xpath("//input[@id='locationId']"));
			location.click();

			WebElement selectLocation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'ant-select-item-option')]/div)[2]")));
			selectLocation.click();

			//Lead Creation
			WebElement leadName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='leadName']")));
			leadName.sendKeys("Test Lead");

			//Lead Description
			WebElement leadDesc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='leadDescription']")));
			leadDesc.sendKeys("This is Automated");
			
			// Apply condition for +5 days from the current date
			LocalDate currentDate = LocalDate.now();								//Current Date
			LocalDate futureDate = currentDate.plusDays(5);							//Future Date
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");		//Date Format
			
		    String formattedFutureDate = futureDate.format(formatter);
			System.out.println('\n' + "Future Date: " + formattedFutureDate + '\n');

			//Select Close Date
			WebElement closeDate = driver.findElement(By.xpath("//input[@id='closeDate']"));
			System.out.print("Close Date" + closeDate);
			closeDate.sendKeys(formattedFutureDate);
			closeDate.sendKeys(Keys.ENTER);
					
			//Selecting the Milestone
			WebElement milestone = driver.findElement(By.xpath("//span[@class ='ant-select-selection-search']//input[@id='milestoneId']"));
			milestone.click();
			Thread.sleep(1500);
			WebElement selectMilestone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[(@class = 'ant-select-item-option-content')])[4]")));
			if(selectMilestone.isEnabled()) {
			selectMilestone.click();
			}
			else {
				System.out.print("MileStone not Found" + selectMilestone);
			}
		
			//Enter the Amount
			WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='amount']")));
			amount.sendKeys("1500");
			
			//Submit Button
			WebElement submitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
			submitButton.click();
			
		}catch(Exception e) {
			System.out.print("All Element not found, Create Leads");
		}
	}

	
}
