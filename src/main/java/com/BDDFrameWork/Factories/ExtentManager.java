package com.BDDFrameWork.Factories;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;

public class ExtentManager {
    private static ExtentManager extentManager;
    private static ThreadLocal<ExtentTest> Textent =new ThreadLocal<ExtentTest>();

    private ExtentManager()
    {

    }

    public static ExtentManager getextentManager()
    {
        if(extentManager==null)
        {
            extentManager=new ExtentManager();
        }
        return extentManager;
    }
    public synchronized ExtentTest getDriverObject()
    {
        synchronized (Textent)
        {
            try {
                Textent.wait(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return Textent.get();
    }

    public synchronized void setDriverObject(ExtentTest test)
    {
        Textent.set(test);
    }
}
