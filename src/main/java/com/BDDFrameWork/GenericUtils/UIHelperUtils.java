package com.BDDFrameWork.GenericUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.util.ArrayList;
import java.util.Set;

public class UIHelperUtils{

	private static WebDriver driver;
	public UIHelperUtils(WebDriver driver)
	{
		driver=driver;
	}

	public static void clickButton(String element) throws Exception {
		UIHelperUtils.findElement(element).click();
	}
	
	
	public static void clickButton(WebElement element)
	{
		try
		{
			element.click();
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	/**
	 * @param element
	 * @return
	 */
	public static By getMechanism(String element) throws Exception {
		try
		{
			By mech=null;
			String mechanism=element.split("~")[0];
			String locator=element.split("~")[1];
			switch (mechanism) {
			case "XPATH":
				mech=By.xpath(locator);
				break;
			case "CSS":
				mech=By.cssSelector(locator);
				break;
			case "ID":
				mech=By.id(locator);
				break;
			case "CLASSNAME":
				mech=By.className(locator);
				break;
			case "LINKTEXT":
				mech=By.linkText(locator);
				break;
			case "PARTIALLINKTEXT":
				mech=By.partialLinkText(locator);
				break;
			case "TAGNAME":
				mech=By.tagName(locator);
				break;
			case "NAME":
				mech=By.name(locator);
				break;
			default:
				break;
			}	
			return mech;
		}
		catch (Exception e) {
			throw e;
		}	
	}
	
	/**
	 * @param locator
	 * @return
	 */
	public static WebElement findElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public static WebElement findElement(String element) throws Exception {
		return driver.findElement(UIHelperUtils.getMechanism(element));
	}
	
	
	public static String windowHandle()
	{
		return driver.getWindowHandle();
	}
	
    public static void switchToAParticularWindow(int windowNumber)
    {
    	Set<String> windows=driver.getWindowHandles();
    	ArrayList<String> listOFwindows=new ArrayList<String>(windows);
    	driver.switchTo().window(listOFwindows.get(windowNumber));
    }
    
    public static void openNewTab()
    {
    	driver.switchTo().newWindow(WindowType.WINDOW);
    }

}
