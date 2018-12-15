package uk.co.strangeowl.scraper.results;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class ResultTest {

    final String TITLE = "Sainsbury's Strawberries";

    private Result result = new Result(
            TITLE
    );

    @Test
    public void resultHasTitle() {
        assertThat(result.getTitle(), equalTo(TITLE));
    }

}
