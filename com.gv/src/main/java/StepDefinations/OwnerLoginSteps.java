package StepDefinations;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.galleryview.com.gv.ConfigReader;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OwnerLoginSteps {
	
//	This is fetch the configure details
	ConfigReader config = new ConfigReader();   		 

//  For ChromeDriver	
	ChromeDriver driver = new ChromeDriver();
	
//	Adding wait for 10 Seconds
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	    System.out.print("Inside- User navigate to the login page");
	    
	    driver.manage().window().maximize();
	    String url = config.getProperty("url");
        // Navigate to the login page
        driver.navigate().to(url);
	}

	@When("user enters username, password and gallerypin")
	public void user_enters_username_password_and_gallerypin() {
	    System.out.print("Inside- user enters username, password and gallerypin");
	    WebElement gallerypin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id, 'gallerypin')]")));
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id, 'email')]")));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id, 'password')]")));

        // Fill the Login details
        String galleryPinValue = config.getProperty("gallerypin");
        String emailValue = config.getProperty("username");
        String passwordValue = config.getProperty("password");
        gallerypin.sendKeys(galleryPinValue);
        email.sendKeys(emailValue);
        password.sendKeys(passwordValue);
        
	}

	@And("click to login button")
	public void click_to_login_button() {
	    System.out.print("Inside- user clicks to the login button");
	    
	    WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@type, 'submit')]")));
        login.click();
	}

	@And("user validate to 2FA page")
	public void user_validate_to_2fa_page() {
	    System.out.print("Inside- User navigate to the 2FA page");
	}

	@Then("user is navigate to the dashboard page")
	public void user_is_navigate_to_the_dashboard_page() {
	    System.out.print("Inside- User navigate to the dashboard page");
	}
}