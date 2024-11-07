package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getWebDriver() {

        return dr.get();
    }

    public static void setDriver(WebDriver driverref) {

        dr.set(driverref);
    }
}
