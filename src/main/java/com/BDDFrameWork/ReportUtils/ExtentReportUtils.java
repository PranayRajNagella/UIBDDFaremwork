package com.BDDFrameWork.ReportUtils;

import com.BDDFrameWork.GenericUtils.PropertiesUtils;

import java.io.File;

public class ExtentReportUtils {

    public static String getReportConfigPath(){
        String reportConfigPath = System.getProperty("user.dir")+ File.separator +PropertiesUtils.getPropertyValue("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }
}
