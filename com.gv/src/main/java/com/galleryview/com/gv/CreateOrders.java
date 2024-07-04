package com.galleryview.com.gv;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrders {
	public CreateOrders(ChromeDriver driver) {
		
		try {
		//CREATE ORDERS
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement createOrders = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'CREATE ORDER')]")));
		createOrders.click();
		System.out.print("log-1");
		
		//ADD PRODUCT
		WebElement addProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'ADD PRODUCT')]")));
		addProduct.click();
		System.out.print("log-2");
		
		//SELECT PRODUCT
		Thread.sleep(2500);
		WebElement product = driver.findElement(By.xpath("(//span[contains(@class,'ant-checkbox')]/input)[3]"));
		product.click();						// ADDED CONDITION IF ARTWORK IS ALREADY RESERVED CHOOSE ANOTHER ONE
				
		WebElement addProd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'ADD TO ORDER')]")));
		addProd.click();
	
		//VERIFY THE BALANCE TO PAY 
		Thread.sleep(2500);
		WebElement balancePay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Balance To Pay')]/following-sibling::*")));
		boolean verifyValue = true;
		balancePay.isDisplayed();
		System.out.print("Value Present" + verifyValue + '\n');
		System.out.print("balance to pay::" +balancePay + '\n');
		
		//Get the Balance To Pay Text
		String BTP = balancePay.getText();
		System.out.print("Balance To Pay Value" + BTP + '\n');
		
		//Replace the Pound sign
		String remove = BTP.replaceAll("£", "");
		
		System.out.print('\n' + "Replace: " + remove);			
		float floatV = Float.parseFloat(remove);			//PARSE THE FLOAT VALUE			
		System.out.print('\n' + "Float value: " + floatV);
		
		int integerValue = (int) floatV;					//CONVERT INTO THE INTEGER
		System.out.print('\n' + "Integer value: " + integerValue + '\n');	
		int divideValue = 2;
		System.out.print("Divide value :" +integerValue/divideValue + '\n');
		
		
		//VERIFY THE MOA VALUE
		WebElement moa = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(), 'Money on Account:')]/../../following-sibling::*/span")));
		System.out.print("MOA: " + moa);
		System.out.print("log-6");
		
	    String amountText = moa.getText();							// GETTING THE STRING VALUE 
	    System.out.print('\n' + "Amount Text:" + amountText );
	    
	    String replace = amountText.replaceAll("£", "");			// REPLACE THE POUND SIGN FROM THE VALUE
	    System.out.print("Replace £ " + replace);
	    String amount = replace.replaceAll(",", "");		
	    System.out.print("Replace, " + replace);
	
	    float floatSym = Float.parseFloat(amount);
		
		int intValue = (int) floatSym;								//CONVERT INTO THE INTEGER
		System.out.print("Integer value: " + intValue);	
		
		//ADDED THE CONDITION IF MOA VALUE IS GREATER THAN THE 0, THEN USE MOA
		double amountValue = Double.parseDouble(amount);			
		if (amountValue > integerValue ) 
		{							 
			System.out.print("Amount is valid: " + amountValue );
			driver.findElement(By.id("accountPayment")).sendKeys(Integer.toString(integerValue/divideValue));
			
			WebElement addMOAbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'ADD MOA TO ORDER')]")));
			addMOAbtn.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'CONFIRM')]"))).click();
			
		} 
		else 																			
			// ELSE USE THE CASH METHOD
		{
			System.out.print("MOA has no minimun value and using Cash Method: ");
			WebElement cash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Cash")));
			cash.sendKeys(Integer.toString(integerValue/divideValue));
			WebElement addC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'ADD CASH PAYMENT TO ORDER')]")));
			addC.click();
			WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'CONFIRM')]")));
			confirm.click();
		}
			//CREATE ORDER BUTTON
			WebElement createOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'CREATE ORDER')]")));
			createOrder.click();
			
			WebElement okButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'OK')]")));
			okButton.click();
		
			//Close Order Confirmation Page
			WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'CLOSE')]")));
			closeBtn.click();
			
			
			//Close Client Button
			new ClientCloseBtn(driver);
			
		}	catch(Exception e){
			System.out.print("Create Order Element");
		
		} /*finally {
			driver.quit();
		}*/
	}
}