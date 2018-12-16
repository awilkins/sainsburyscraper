package uk.co.strangeowl.scraper.page;

import com.google.common.annotations.VisibleForTesting;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import uk.co.strangeowl.scraper.results.Result;
import uk.co.strangeowl.scraper.results.Results;

import java.math.BigDecimal;

public class ProductPageScraper {

    final static String NON_NUMERIC = "[^0-9\\.]";

    @VisibleForTesting
    static String getTitle(Document page) {
        return page.selectFirst(".productSummary h1").text();
    }

    @VisibleForTesting
    static String getDescription(Document page) {

        Element description = page.select(".productText p")
                .stream()
                .filter(element -> element.text().length() > 0)
                .findAny()
                .orElse(null);

        return description.text();

    }

    @VisibleForTesting
    static BigDecimal getUnitPrice(Document page) {
        String priceText = page.selectFirst(".pricePerUnit").text();
        // Remove all the non-numeric bits
        priceText = priceText.replaceAll(NON_NUMERIC, "");
        return new BigDecimal(priceText);
    }

    @VisibleForTesting
    static Integer getKcalsPerHundredGrams(Document page) {
        Elements nutritionCells = page.select("tr[class*=\"tableRow\"] > td:first-of-type");
        Element kilocals = nutritionCells.stream()
                .filter(element -> element.text().contains("kcal"))
                .findAny()
                .orElse(null);

        if (kilocals == null) return null;

        return Integer.valueOf(kilocals.text().replaceAll(NON_NUMERIC, ""));
    }

    public static Result scrape(Document page) {
        return new Result(
                getTitle(page),
                getDescription(page),
                getUnitPrice(page),
                getKcalsPerHundredGrams(page)
        );
    }
}
