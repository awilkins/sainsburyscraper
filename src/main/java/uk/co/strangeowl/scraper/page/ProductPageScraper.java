package uk.co.strangeowl.scraper.page;

import org.jsoup.nodes.Document;

import java.math.BigDecimal;

public class ProductPageScraper {

    public static String getTitle(Document page) {
        return page.selectFirst(".productSummary h1").text();
    }

    public static String getDescription(Document page) {
        return page.selectFirst(".productText p").text();
    }

    public static BigDecimal getUnitPrice(Document page) {
        String priceText = page.selectFirst(".pricePerUnit").text();
        System.out.println(priceText);
        return new BigDecimal(priceText);
    }
}
