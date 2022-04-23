package com.BDDFrameWork.Factories;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static DriverManager driverManager;
    private static final ThreadLocal<WebDriver> Tdriver= new ThreadLocal<>();

    private DriverManager()
    {

    }

    public static DriverManager getDriverManager()
    {
        if(driverManager==null)
        {
            driverManager=new DriverManager();
        }
        return driverManager;
    }
    public synchronized WebDriver getDriverObject()
    {
        synchronized (Tdriver)
        {
            try {
                Tdriver.wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return Tdriver.get();
    }

    public synchronized void setDriverObject(WebDriver driver)
    {
        Tdriver.set(driver);
    }

    public synchronized void removeDriver()
    {
        Tdriver.get().close();
        Tdriver.remove();
    }
}
