package com.BDDFrameWork.BrowserUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {

    public static WebDriver getBrowser(WebDriver driver, String Browser)
    {
        Browser=Browser.toUpperCase();
        if ("CHROME".equals(Browser)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if ("EDGE".equals(Browser)) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }

    public static void launchURL(WebDriver driver,String URL)
    {
        driver.get(URL);
    }
}
