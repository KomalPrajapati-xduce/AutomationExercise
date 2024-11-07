package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class DataReader {
    private static Map<String, String> testData;

    public static void loadData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            testData = objectMapper.readValue(
                    new File(System.getProperty("user.dir") + "/src/test/resources/data/testData.json"),
                    Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getData(String key) {

        return testData.get(key);
    }
}
