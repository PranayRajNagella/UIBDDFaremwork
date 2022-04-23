package com.BDDFrameWork.GenericUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UtilityTester {

    public static void main(String[] args) {
        List<Object> mylist=TestDataUtility.getTestDataFromJson("Login","LoginValidChrome");
        System.out.println( ((Map<String,Object>)mylist.iterator().next()));
    }
}
