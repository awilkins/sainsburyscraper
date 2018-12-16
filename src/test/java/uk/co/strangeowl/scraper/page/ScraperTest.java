package uk.co.strangeowl.scraper.page;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;


public class ScraperTest {

    private static String getPage() {
        try {
            return Resources.toString(
                    Resources.getResource(ScraperTest.class, "berries-cherries-currants6039.html"),
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


}
