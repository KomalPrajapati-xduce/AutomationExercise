package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinkPage {
    private BrokenLinkPage(){
    }

    public static BrokenLinkPage getBrokenLink(){
        return new BrokenLinkPage();
    }

    // Method to find all the anchor elements with href attribute
    public List<String> findAllLinks() {
        List<String> links = new ArrayList<>();
        List<WebElement> linkElements = WaitFactory.waitTillItemsVisible(By.tagName("a"));

//        for (WebElement linkElement : linkElements) {
//            String url = linkElement.getAttribute("href");
//            if (url != null && !url.isEmpty()) {
//                links.add(url);
//            }
//        }
        return links;
    }

    // Method to get the status code of a URL
    public int getStatusCode(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            return connection.getResponseCode();
        } catch (IOException e) {
            System.out.println("Error checking URL: " + urlString + " - " + e.getMessage());
            return 404;
        }
    }

    // Method to get broken links by checking the status codes
    public List<String> getBrokenLinks() {
        List<String> brokenLinks = new ArrayList<>();
        List<String> allLinks = findAllLinks();

        for (String link : allLinks) {
            int statusCode = getStatusCode(link);
            if (statusCode != 200) {
                brokenLinks.add(link);
            }
        }
        return brokenLinks;
    }
}
