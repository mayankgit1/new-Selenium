
package com.galleryview.com.gv;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageArtworkProducts {
	public ManageArtworkProducts(ChromeDriver driver) {
		
		ConfigReader config = new ConfigReader();
		
		String title = config.getArtwork("title");
		String artistname = config.getArtwork("artistName");
        String description = config.getArtwork("description");
        String ShortDesc = config.getArtwork("shortDesc");
        String Price = config.getArtwork("price");
        String Salesprice = config.getArtwork("salesprice");
        String ProductImage = config.getArtwork("ProductImage");
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			new SideBarManageArtwork(driver);
			
			WebElement addNewBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='ADD NEW']")));
			addNewBtn.click();
			
			//Edit Product Page
			WebElement artTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='basic_name']")));
			boolean verify = artTitle.isDisplayed();
			System.out.print("Art Title visible" + verify +'\n');
			artTitle.sendKeys(title);
			
//			Artist Name
			WebElement artistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='basic_artistName']")));
			boolean verifyartist = artistName.isDisplayed();
			System.out.print("Artist Name Display" + verifyartist  +'\n');
			artistName.sendKeys(artistname);
			artistName.sendKeys(Keys.ENTER);
			
			Thread.sleep(2500);
//			Description Details
			WebElement descrip = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'public-DraftEditor-content')])[1]")));
			descrip.click();
			Thread.sleep(1500);
			descrip.sendKeys(description);
			
			WebElement Shortdescription = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'public-DraftEditor-content')])[2]")));
			Shortdescription.sendKeys(ShortDesc);
			
//			Regular Price details
			WebElement regPrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='basic_regularPrice']")));
			regPrice.sendKeys(Price);
			
			WebElement salePrice = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='basic_salePrice']")));
			salePrice.sendKeys(Salesprice);
			
//			Internal Details filled 	/* Product Type */
			WebElement openType = driver.findElement(By.xpath("//input[@id='basic_typeId']"));
			openType.click();
			
			Thread.sleep(1000);
//			Selecting the Product Type
			WebElement selectType = driver.findElement(By.xpath("//div[text()='Artwork']"));
			if(selectType.isDisplayed()) {
			selectType.click();
			}
			
//			Selecting the Location
			WebElement openlocation = driver.findElement(By.xpath("//input[@id='basic_locationId']"));
			openlocation.click();
			Thread.sleep(1500);
			WebElement selectlocation = driver.findElement(By.xpath("//div[text()='Finland Forebolt']"));
			if(selectlocation.isDisplayed()) {
				selectlocation.click();
			}
			
//			Selecting Artwork Type:
			WebElement openartworktype = driver.findElement(By.xpath("//input[@id='basic_edition']"));
			openartworktype.click();
			Thread.sleep(1000);
			WebElement selectartwork = driver.findElement(By.xpath("//div[text()='Open']"));
			if(selectartwork.isDisplayed()) {
				selectartwork.click();
			}
			
			Thread.sleep(1000);
//			Selecting Product Image:
			WebElement prodImage = driver.findElement(By.xpath("(//span[@class='ant-upload']/input)[1]"));
			prodImage.sendKeys(ProductImage);
			
//			Save the Artwork File
			WebElement save = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='SAVE']")));
			save.click();
			
		}catch(Exception e) {
			System.out.print("System Error 404");
//			driver.quit();
		}
	}

}
