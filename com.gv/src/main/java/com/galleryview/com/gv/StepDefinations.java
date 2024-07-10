package com.galleryview.com.gv;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class StepDefinations {
	public class StepDefinitions {

	    @Given("^User is on the login page$")
	    public void user_is_on_the_login_page() {
	        // Implementation of navigating to the login page
	    }

	    @When("^User enters username \"([^\"]*)\" gallerypin \\\"([^\\\"]*)\\\" and password \"([^\"]*)\"$")
	    public void user_enters_username_and_password(String username, String password) {
	        // Implementation of entering username and password
	    }

	    @When("^Clicks login button$")
	    public void clicks_login_button() {
	        // Implementation of clicking login button
	    }

	    @Then("^User is navigated to the home page$")
	    public void user_is_navigated_to_the_home_page() {
	        // Implementation of verifying navigation to home page
	    }
	}
	}
