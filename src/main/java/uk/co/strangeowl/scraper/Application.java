package uk.co.strangeowl.scraper;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import uk.co.strangeowl.scraper.page.IndexPageScraper;
import uk.co.strangeowl.scraper.page.ProductPageScraper;
import uk.co.strangeowl.scraper.results.Result;
import uk.co.strangeowl.scraper.results.ResultSerializer;
import uk.co.strangeowl.scraper.results.Results;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Application {

    public static final String TARGET_PAGE = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";

    private static Document getPage(String url) {
        try {
            return getPage(new URL(url));
        }
        catch (MalformedURLException malfex) {
            System.out.println("Malformed URL : " + url);
            return null;
        }
    }

    private static Document getPage(URL url) {
        try {
            Document page = Jsoup.connect(url.toString()).get();
            return page;
        }
        catch (IOException ioex) {
            System.out.println("Failed to get page : " + url.toString());
            return null;
        }
    }



    private static void addResultFromUrl(String base, String url, Results results) {
        try {
            URL baseUrl = new URL(base);
            URL productUrl = new URL(baseUrl, url);
            Document productPage = getPage(productUrl.toString());
            Result result = ProductPageScraper.scrape(productPage);
            results.add(result);
        }
        catch (MalformedURLException malfex) {
            System.out.println("Bad URL");
            System.exit(1);
        }
    }

    public static void main(String[] args) {

        // Get the main page
        Document indexPage = getPage(TARGET_PAGE);

        List<String> productUrls = IndexPageScraper.productLinks(indexPage);

        Results results = new Results();
        for(String url : productUrls) {
            addResultFromUrl(TARGET_PAGE, url, results);
        }

        System.out.print(
                ResultSerializer.serialize(results)
        );
    }
}
