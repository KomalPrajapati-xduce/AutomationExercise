package steps;

import io.cucumber.java.en.*;
import pages.BrokenLinkPage;

import java.util.List;


public class BrokenLinkSteps {
    @Given("User is on home page")
    public void user_is_on_home_page() {

    }

    @Then("check the broken links on the page")
    public void check_the_broken_links_on_the_page() {
        List<String> brokenLinks = BrokenLinkPage.getBrokenLink().getBrokenLinks();
        System.out.println(brokenLinks.size());
    }

}
