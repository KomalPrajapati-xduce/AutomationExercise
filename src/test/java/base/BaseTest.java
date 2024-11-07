package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.DriverManager;
import utils.PropertyUtils;

public class BaseTest {
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        DriverManager.setDriver(new ChromeDriver(options));
        DriverManager.getWebDriver().get(PropertyUtils.get("url"));
    }

    public void tearDown() {
        DriverManager.getWebDriver().quit();
    }
}

