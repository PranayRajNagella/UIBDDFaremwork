package com.BBDFrameWork.Base;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/resources/FeatureFiles",glue={"com.BDDFrameWork.stepdefinitions"},
        plugin = { "pretty", "html:target/cucumber-reports.html" },
        monochrome = true)
public class TestRunner {

    @Before()
    public static void setUp()
    {

    }
    /*@BeforeClass
    public static void setUP()
    {
        PropertiesUtils PRU=new PropertiesUtils();
    }*/

   /* @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(ExtentReportUtils.getReportConfigPath()));
    }*/
}
