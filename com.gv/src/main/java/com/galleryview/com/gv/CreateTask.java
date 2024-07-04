package com.galleryview.com.gv;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateTask {
		public CreateTask(ChromeDriver driver){
			try {

//				new SidebarTasks(driver);
    //Click to DueDate
    Thread.sleep(2000);
    WebElement dueDate = driver.findElement(By.xpath("//input[contains(@id, 'dueDate')]"));
    dueDate.click();
    
    //Select Due Date
    Thread.sleep(2000);
    WebElement selectDate = driver.findElement(By.xpath("//div[contains(@class,'ant-picker-footer')]/a"));
    selectDate.click();
    
    //Select Task Type
    WebElement taskType = driver.findElement(By.xpath("//input[contains(@id, 'taskType')]"));
    taskType.click();
    
    Thread.sleep(3000); 
    WebElement selectType = driver.findElement(By.xpath("//div[contains(@class, 'ant-select-item ant-select-item-option ant-select-item-option-active')]/div"));
    selectType.isDisplayed();
    selectType.click();
   
    //Select Task Priority
    WebElement priority = driver.findElement(By.id("taskPriority"));
    priority.click();
    Thread.sleep(3000);
    
    WebElement selectPriority = driver.findElement(By.xpath("//div[contains(@class, 'ant-select-item-option')]//div[contains(text(), 'High')]"));
    if(selectPriority.isDisplayed()) {
    	selectPriority.click();
    } else {
    	System.out.print("No Such Element Found" + selectPriority);
    }
    
    //Select Task Status
    WebElement status = driver.findElement(By.id("taskStatus"));
    status.click();
    Thread.sleep(2000);
    WebElement selectStatus = driver.findElement(By.xpath("//div[contains(@class, 'ant-select-item ant-select-item-option ant-select-item-option-active')]/div[contains(text(),'Completed')]"));
    selectStatus.click();
    
    //Select Task Description
    WebElement description = driver.findElement(By.id("taskDescription"));
    description.sendKeys("This is for the Testing Purpose[Automated]");
    Thread.sleep(5000);
    
    //Select Client
    
    
    WebElement chooseClient = driver.findElement(By.id("clientId"));
    boolean client = chooseClient.isSelected();
    System.out.print("IsSelected:: " + client);
	Thread.sleep(1500);
    WebElement selectClient = driver.findElement(By.xpath("//div/form/div/div[1]/section/div[2]/div/div[2]/div/div/div/div/span[2]"));
    if(!selectClient.isSelected()) {
    	System.out.print('\n' + "Client has already value" + '\n');
    }
//      selectClient.click();
    
   //Select Consultant
    Thread.sleep(1200);
    WebElement consultant = driver.findElement(By.id("ownerId"));
    consultant.click();
    Thread.sleep(1200);
    WebElement selectConsultant = driver.findElement(By.xpath("//div[1]/div[contains(text(),'Finland Forcebolt')]"));
    selectConsultant.click();
	Thread.sleep(1500);
   
    // Select Location
	WebElement location = driver.findElement(By.xpath("//label[text()= 'Location' and @class = 'ant-form-item-required']/../following-sibling::div/div/div/div/div/span/input"));
    location.click();
    Thread.sleep(2000);
    WebElement selectLoc = driver.findElement(By.xpath("//div[contains(@title, 'New Galls')]/div"));
    if(!selectLoc.isDisplayed()) {
    	System.out.print("Select::" + selectLoc + '\n');
    	selectLoc.click();
    }
    
    //Submit Task
    Thread.sleep(1500);
    WebElement submit = driver.findElement(By.xpath("//span[contains(text(),'SAVE TASK')]"));
    submit.click();
    
    // Wait for some time to observe the result
    Thread.sleep(4000);
    } catch (NoSuchElementException e) {
        System.out.println("Element not found: " + e.getMessage());
        e.printStackTrace();
    } catch (WebDriverException e) {
        System.out.println("WebDriver exception occurred: " + e.getMessage());
        e.printStackTrace();
    } catch (InterruptedException e) {
        System.out.println("Thread interrupted: " + e.getMessage());
        e.printStackTrace();
    } 
//    finally {
//        driver.quit(); // Close the browser session
//    }
}
}