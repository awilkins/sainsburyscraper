package uk.co.strangeowl.scraper.page;

import org.jsoup.nodes.Document;

public class ProductPageScraper {

    public static String getTitle(Document page) {
        return page.selectFirst(".productSummary h1").text();
    }

}
