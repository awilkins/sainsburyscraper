package uk.co.strangeowl.scraper.page;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import javax.lang.model.util.Elements;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;


public class IndexPageScraperTest {

    private static String getPage() {
        try {
            return Resources.toString(
                    Resources.getResource(IndexPageScraperTest.class, "berries-cherries-currants6039.html"),
                    Charsets.UTF_8
            );
        }
        catch (IOException ioex) {
            System.out.println("This shouldn't happen... ");
            return null;
        }

    }

    private static final Document page = Jsoup.parse(getPage());

    @Test
    public void canFindStrawberryProductLink() {
        Element firstLink = page.selectFirst(".product a");
        assertThat(firstLink.attr("href"), containsString("british-strawberries"));
    }

    @Test
    public void canScrapeProductLinks() {
        List<String> links = IndexPageScraper.productLinks(page);

        // First link
        assertThat(links, hasItem(containsString("british-strawberries")));

        // Last link
        assertThat(links, hasItem(containsString("cherry---strawberry-pack")));
    }

    @Test
    public void avoidsCrossSellProducts() {
        List<String> links = IndexPageScraper.productLinks(page);
        assertThat(links, not(hasItem(containsString("klip-lock-storage"))));
    }


}
