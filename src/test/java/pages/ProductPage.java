package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    Actions actions = new Actions(DriverManager.getWebDriver());
    JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();

    private ProductPage() {
    }

    public static ProductPage getProduct() {
        return new ProductPage();
    }

    private final By txtCategory = By.cssSelector("[href='#Men']");
    private final String txtProduct = "//*[@id='Men']//li[normalize-space()='text']/a";
    private final By productInfo = By.cssSelector("[class*='productinfo']");
    //private final By addToCartBtn = By.cssSelector(".overlay-content [class*='add-to-cart']");
    private final By continueShoppingBtn = By.cssSelector("[class*=btn-success]");
    private final By cartBtn = By.cssSelector("a[href='/view_cart']");

    public void selectCategory() {
        WebElement categoryElement = WaitFactory.waitTillVisible(txtCategory);
        categoryElement.click();
    }

    public void selectProduct(String productType) {
        String prod = txtProduct.replace("text", productType);
        js.executeScript("arguments[0].click();", DriverManager.getWebDriver().findElement(By.xpath(prod)));
    }

    public void addProductsToCart() {
        List<WebElement> products = WaitFactory.waitTillItemsVisible(productInfo);
        for (int i = 1; i <= products.size(); i++) {
            String addToCartXPath = "(//*[@class='overlay-content']/a)[" + i + "]";
            WebElement addToCartButton = DriverManager.getWebDriver().findElement(By.xpath(addToCartXPath));
            actions.moveToElement(addToCartButton).build().perform();
            js.executeScript("arguments[0].click();", addToCartButton);

            WebElement continueShopping = DriverManager.getWebDriver().findElement(continueShoppingBtn);
            Boolean cs = WaitFactory.waitTillTextPresent(continueShopping, "Continue Shopping");
            js.executeScript("arguments[0].scrollIntoView(true);", continueShopping);
            js.executeScript("arguments[0].click();", continueShopping);

            //WaitFactory.waitToSync(2);
        }
        WebElement cartElement = WaitFactory.waitTillVisible(cartBtn);
        cartElement.click();
    }

}
