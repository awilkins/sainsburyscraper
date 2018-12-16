package uk.co.strangeowl.scraper.page;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.math.BigDecimal;
import java.text.StringCharacterIterator;

public class ProductPageScraper {

    final static String NON_NUMERIC = "[^0-9\\.]";

    public static String getTitle(Document page) {
        return page.selectFirst(".productSummary h1").text();
    }

    public static String getDescription(Document page) {
        return page.selectFirst(".productText p").text();
    }

    public static BigDecimal getUnitPrice(Document page) {
        String priceText = page.selectFirst(".pricePerUnit").text();
        // Remove all the non-numeric bits
        priceText = priceText.replaceAll(NON_NUMERIC, "");
        return new BigDecimal(priceText);
    }

    public static Integer getKcalsPerHundredGrams(Document page) {
        Elements nutritionCells = page.select("tr[class*=\"tableRow\"] > td:first-of-type");
        Element kilocals = ((org.jsoup.select.Elements) nutritionCells).stream()
                .filter(element -> element.text().contains("kcal"))
                .findAny()
                .orElse(null);

        if (kilocals == null) return null;

        return Integer.valueOf(kilocals.text().replaceAll(NON_NUMERIC, ""));
    }
}
