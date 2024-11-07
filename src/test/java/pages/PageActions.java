package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.DriverManager;

public class PageActions {
    PageActions() {
    }

    private final WebDriver driver = DriverManager.getWebDriver();

    public WebDriver fetchDriver() {
        return driver;
    }

    public void click(By locator) {
        fetchDriver().findElement(locator).click();
    }

    public void click(WebElement element) {
        element.click();
    }

    public void sendKeys(By locator, String value) {
        fetchDriver().findElement(locator).sendKeys(value);
    }

    public void sendKeys(WebElement element, String value) {

        element.sendKeys(value);
    }
}
