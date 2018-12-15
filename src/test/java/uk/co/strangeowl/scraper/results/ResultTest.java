package uk.co.strangeowl.scraper.results;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class ResultTest {

    final String TITLE = "Sainsbury's Strawberries";
    final String DESCRIPTION = "Delicious, juicy, strawberries";

    private Result result = new Result(
            TITLE,
            DESCRIPTION
    );

    @Test
    public void resultHasTitle() {
        assertThat(result.getTitle(), equalTo(TITLE));
    }

    @Test
    public void resultHasDescription() {
        assertThat(result.getDescription(), equalTo(DESCRIPTION));
    }

}
