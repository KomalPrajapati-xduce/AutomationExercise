package pages;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;
import java.util.List;

public class WaitFactory {
    WaitFactory() {
    }

    private static final WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(30));

    public static WebElement waitTillClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitTillClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitTillVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitTillVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitTillPresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static List<WebElement> waitTillItemsVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    //Use this method in case of dire need only
    public static void waitToSync(long waitTime) {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(waitTime));
    }

    public static Boolean waitTillStale(WebElement element) {
        return wait.until(ExpectedConditions.stalenessOf(element));
    }

    public static Boolean waitTillTextPresent(WebElement element, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void waitTillInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

}
