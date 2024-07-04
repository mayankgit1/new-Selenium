package com.galleryview.com.gv;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateClient{

	public CreateClient(ChromeDriver driver){
		
        try {
        	
//         Open Side bar
        WebElement Sidebar = driver.findElement(By.xpath("/html/body/div[1]/section/section/header/section/div/div/div[1]/h4/header/span"));
        Sidebar.click();
        Thread.sleep(4000);
        WebElement OpenClient = driver.findElement(By.xpath("/html/body/div[1]/section/section/header/section/section/div/div[3]/div/div/div[2]/ul/li[2]/span/div"));
        OpenClient.click();
        Thread.sleep(5000);
        WebElement addClients = driver.findElement(By.xpath("//span[contains(text(), 'ADD CLIENT')]"));
        addClients.click();
        Thread.sleep(1000);
        
        //Fill the Contact Details with Communication and Add Client
        WebElement FName = driver.findElement(By.xpath("//input[contains(@id,'firstName')]"));
        FName.sendKeys("Automated");
        
        WebElement LastName = driver.findElement(By.xpath("//input[contains(@id,'lastName')]"));
        LastName.sendKeys("Client");
        
        WebElement Salutation = driver.findElement(By.xpath("//input[contains(@id,'salutation')]"));
        Salutation.click();
        Thread.sleep(2000);
        WebElement select = driver.findElement(By.xpath("//div[3]/div/div/div/div[2]/div/div/div/div[3]/div"));
        select.click();
        
        WebElement Email = driver.findElement(By.xpath("//input[contains(@id,'emailAddress1')]"));
        Email.sendKeys("automatedemail@gmail.com");
             
        WebElement methodCheckbox = driver.findElement(By.xpath("/html/body/div[1]/section/section/main/div[3]/form/div/div[2]/div[4]/div[2]/div/div/div/div/div/label/span/input"));
        methodCheckbox.click();
        
        WebElement permissionCheckbox = driver.findElement(By.xpath("/html/body/div[1]/section/section/main/div[3]/form/div/div[2]/div[5]/div[3]/div/div/div/div/div/label/span/input"));
        permissionCheckbox.click();
        
        WebElement addClient = driver.findElement(By.xpath("//span[contains(text(), 'ADD CLIENT')]"));
        addClient.click();    
        
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
        
	}
}