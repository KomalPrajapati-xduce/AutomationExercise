package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtils {
    private static final Map<String, String> CONFIGMAP = new HashMap<>();
    private static final Properties property = new Properties();

    static {
        FileInputStream file;
        try {
            file = new FileInputStream(System.getProperty("user.dir") +
                    "/src/test/resources/properties/config.properties");
            property.load(file);

            for (Map.Entry<Object, Object> entry : property.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
            }
        } catch (IOException e) {
            throw new RuntimeException("File is not found at the provided path.");
        }
    }

    private PropertyUtils() {
    }

    public static String get(String key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.toLowerCase()))) {
            throw new RuntimeException("Property name " + key + " is no found. Check config.properties");
        }
        return CONFIGMAP.get(key.toLowerCase());
    }
}
