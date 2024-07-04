package com.galleryview.com.gv;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateLeadButton {
public CreateLeadButton(ChromeDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	WebElement createLead = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='button']/span")));
	if(createLead.isDisplayed()) {
	createLead.click();
	}
	else {
		System.out.print("Element not present");
	}

}
}
