package steps;

import io.cucumber.java.en.Then;
import pages.BrokenLinkPage;


public class BrokenLinkSteps {
    @Then("Validate no broken links are present on page")
    public void validate_no_broken_links_are_present_on_page() {
        BrokenLinkPage.getBrokenLink().brokenLinkFetcher();
    }
}
