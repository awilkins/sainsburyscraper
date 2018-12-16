package uk.co.strangeowl.scraper.page;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public class IndexPageScraper {

    /**
     * Scrape a Jsoup document for the product links we want
     * @param page
     * @return
     */
    public static List<String> productLinks(Document page) {
        Elements links = page.select(".productInfo a");
        return links.eachAttr("href");
    }

}
