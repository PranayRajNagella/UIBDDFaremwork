package com.BDDFrameWork.stepdefinitions;

import com.BDDFrameWork.BrowserUtils.BrowserFactory;
import com.BDDFrameWork.Factories.DriverManager;
import com.BDDFrameWork.GenericUtils.PropertiesUtils;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CommonStepDefinition {
    public static String browser;
    public WebDriver driver;
    public PropertiesUtils prop;

    @Given("Do the Intial SetUP")
    public void do_the_intial_set_up() {
        prop=new PropertiesUtils();
    }

    @Given("Launching A Particular {string}")
    public void launching_a_particular(String browser) {
        browser=browser;
        DriverManager.getDriverManager().setDriverObject(BrowserFactory.getBrowser(driver,browser));
    }

    @Given("Shoutdown Browser")
    public void shoutdown_browser() {
        DriverManager.getDriverManager().removeDriver();
    }


}
