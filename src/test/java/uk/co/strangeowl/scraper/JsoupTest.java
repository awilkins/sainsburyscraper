package uk.co.strangeowl.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class JsoupTest {

    @Test
    public void jsoupCanFetchTestPage() throws IOException {
        Document doc = Jsoup.connect(Application.TARGET_PAGE).get();

        final String EXPECTED_TITLE = "Berries, cherries & currants | Sainsbury's";

        assertThat(doc.title(), equalTo(EXPECTED_TITLE));
    }
}
