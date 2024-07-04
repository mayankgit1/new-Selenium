package com.galleryview.com.gv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Signup {

	public static void main(String[] args) {
		
		ConfigReader config = new ConfigReader();    
		
		String url = config.getProperty("url");
    	String galleryname = config.getProperty("gallerypin");
        String street = config.getProperty("username");
        String town = config.getProperty("password");
        String city = config.getProperty("url");
    	String county = config.getProperty("gallerypin");
        String postcode = config.getProperty("username");
        String gallerytelephone = config.getProperty("password");
        String fname = config.getProperty("url");
    	String lname = config.getProperty("gallerypin");
        String email = config.getProperty("username");
        String mobile = config.getProperty("password");
        
		try {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get(url);
		
		Thread.sleep(2000);
		//Gallery Details
		WebElement GalleryName = driver.findElement(By.xpath("//input[contains(@id, 'galleryName')]"));
		WebElement Street = driver.findElement(By.xpath("//input[contains(@id, 'street')]"));
		WebElement Town = driver.findElement(By.xpath("//input[contains(@id, 'town')]"));
		WebElement City = driver.findElement(By.xpath("//input[contains(@id, 'city')]"));
		WebElement County = driver.findElement(By.xpath("//input[contains(@id, 'country')]"));
		WebElement PostCode = driver.findElement(By.xpath("//input[contains(@id, 'postCode')]"));
		WebElement GalleryTelephone = driver.findElement(By.xpath("//input[contains(@id, 'telephoneNumber')]"));
				
//		Gallery AdminUser Details
		WebElement FirstName = driver.findElement(By.xpath("//input[contains(@id, 'pcFirstName')]"));
		WebElement LastName = driver.findElement(By.xpath("//input[contains(@id, 'pcLastName')]"));
		WebElement EmailAddress = driver.findElement(By.xpath("//input[contains(@id, 'pcEmail')]"));
		WebElement Mobile = driver.findElement(By.xpath("//input[contains(@id, 'pcMobilephone')]"));
	
		//Billing Details
		Thread.sleep(2000);
	    WebElement GVAdminCheckbox = driver.findElement(By.xpath("//input[contains(@class,'ant-checkbox-input')]"));
		WebElement Proceed = driver.findElement(By.xpath("//button[contains(@class, 'ant-btn ant-btn-primary css-huh1ep')]"));
		
		//Provided Details		
		GalleryName.sendKeys(galleryname);
		Street.sendKeys(street);
		Town.sendKeys(town);
		City.sendKeys(city);
		County.sendKeys(county);
		PostCode.sendKeys(postcode);
		GalleryTelephone.sendKeys(gallerytelephone);
		FirstName.sendKeys(fname);
		LastName.sendKeys(lname);
		EmailAddress.sendKeys(email);
		Mobile.sendKeys(mobile);
		GVAdminCheckbox.click();
		Thread.sleep(1000);
		Proceed.click();
		
		//Congratulation Module
		Thread.sleep(5000);
		WebElement Congrats = driver.findElement(By.xpath("//button[contains(@class,'ant-btn ant-btn-primary')]/a"));
		Congrats.click();
		
		 // Wait for some time to observe the result       
		Thread.sleep(2000);
		} catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            // Quit the WebDriver
            ChromeDriver driver = new ChromeDriver();
            driver.quit();
        }
    }
}