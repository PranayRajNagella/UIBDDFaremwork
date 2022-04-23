package com.BDDFrameWork.GenericUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {

    private static final Properties prop=new Properties();

    public PropertiesUtils()
    {
        try
        {
            FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/propertyFiles/ConstantProperty.properties");
            prop.load(fis);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    public PropertiesUtils(String file)
    {
        try
        {
            FileInputStream fis=new FileInputStream(file);
            prop.load(fis);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }

    public static String getPropertyValue(String key)
    {
        return prop.getProperty(key);
    }

    public static void setPropertyValue(String key,String value)
    {
        prop.setProperty(key,value);
    }

}
