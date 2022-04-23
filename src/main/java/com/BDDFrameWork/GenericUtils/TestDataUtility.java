package com.BDDFrameWork.GenericUtils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static com.BDDFrameWork.GenericUtils.GlobalConstants.TestDataJson;

public class TestDataUtility {

    public static List<Object> getTestDataFromJson(String TestScriptName,String Scenario)
    {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode startNode = mapper.readTree(new File(TestDataJson)).get("TestData");
            JsonNode testDataNode=null;
            for(int i=0;i<startNode.size();i++)
            {
                if(startNode.get(i).get("TestScriptName").asText().equalsIgnoreCase(TestScriptName))
                {
                    JsonNode testCasesNode=startNode.get(i).get("TestCases");
                    for(int j=0;j<testCasesNode.size();j++)
                    {

                        if(testCasesNode.get(j).get("TestCase").asText().equalsIgnoreCase(Scenario))
                        {
                            testDataNode=testCasesNode.get(j).get("data");
                            break;
                        }
                    }
                }
                break;
            }
            List<Object> testDataArray=mapper.convertValue(testDataNode,new TypeReference<List<Object>>() {});
            testDataArray.removeIf(n -> checkRemove(n));
            return  testDataArray;
        }
        catch (Exception e)
        {
           e.printStackTrace();
        }
        return null;
    }

    public static boolean checkRemove(Object testData)
    {
        return Boolean.parseBoolean(((Map<String,Object>)testData).get("runmode").toString())?false:true;
    }

    public static String readJsonAsString(String filePath) throws IOException {
            return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}
