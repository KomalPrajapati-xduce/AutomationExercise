package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ProductPage;

public class ProductSteps {
    @Given("User is on home page")
    public void user_is_on_home_page() {
       // ProductPage.getProduct().selectCategory();
    }

    @Then("selects product {string}")
    public void selects_product(String productname) {
        ProductPage.getProduct().selectProduct(productname);
    }

    @Then("clicks on cart button and verify the product")
    public void clicks_on_cart_button_and_verify_the_product() {
        ProductPage.getProduct().addProductsToCart();

    }
}
