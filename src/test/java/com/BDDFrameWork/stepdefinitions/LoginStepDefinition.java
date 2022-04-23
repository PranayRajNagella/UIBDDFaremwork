package com.BDDFrameWork.stepdefinitions;

import com.BDDFrameWork.BrowserUtils.BrowserFactory;
import com.BDDFrameWork.Factories.DriverManager;
import com.BDDFrameWork.GenericUtils.PropertiesUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

    @Given("User Launch's the {string}")
    public void user_launch_s_the_homepage_url(String url) {
        System.out.println(url+ "the url is"+PropertiesUtils.getPropertyValue(url));
        BrowserFactory.launchURL(DriverManager.getDriverManager().getDriverObject(), PropertiesUtils.getPropertyValue(url));
    }

    @When("User enter a valid {string}")
    public void user_enter_a_valid(String string) {
        System.out.println("Username Entry");
    }
    @Then("User click on login")
    public void user_click_on_login() {
        System.out.println("Click on login Entry");
    }
    @Then("Verify the landing on home page")
    public void verify_the_landing_on_home_page() {
        System.out.println("Landing Page");
    }
}
