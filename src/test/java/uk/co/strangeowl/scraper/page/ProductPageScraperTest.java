package uk.co.strangeowl.scraper.page;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;


public class ProductPageScraperTest {

    static Document getPage(String pageName) {
        try {
            return Jsoup.parse(
                    Resources.toString(
                            Resources.getResource(ProductPageScraperTest.class, pageName),
                            Charsets.UTF_8
                    )
            );
        }
        catch (IOException ioex) {
            System.out.println("Shouldn't happen..");
            return null;
        }
    }

    static final Document strawberries = getPage("strawberries.html");
    static final Document cherryBerries = getPage("cherry-and-strawberry-pack.html");

    @Test
    public void canGetTitle() {
        String title = ProductPageScraper.getTitle(strawberries);
        assertThat(title, equalTo("Sainsbury's Strawberries 400g"));
    }

    @Test
    public void canGetDescription() {
        String description = ProductPageScraper.getDescription(strawberries);
        assertThat(description, equalTo("by Sainsbury's strawberries"));
    }

    @Test
    public void onlyGetFirstLineOfDescription() {
        String description = ProductPageScraper.getDescription(cherryBerries);
        assertThat(description, equalTo("British Cherry & Strawberry Mixed Pack"));
        assertThat(description, not(containsString("Union Flag")));
    }

    @Test
    public void canGetUnitPrice() {
        BigDecimal price = ProductPageScraper.getUnitPrice(strawberries);
        BigDecimal expected = new BigDecimal("1.75");
        assertThat(price, equalTo(expected));
    }

    @Test
    public void canGetKcalPerHundredGrams() {
        Integer kcals = ProductPageScraper.getKcalsPerHundredGrams(strawberries);
        assertThat(kcals, equalTo(33));
    }
}
