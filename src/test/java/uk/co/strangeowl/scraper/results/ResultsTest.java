package uk.co.strangeowl.scraper.results;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class ResultsTest {

    Result one = new Result(
            "Cheese",
            "Very nice cheese, Grommit",
            new BigDecimal("2.50"),
            120
    );

    @Test
    public void weCanAddResults() {
        Results results = new Results();
        results.add(one);
    }

    @Test
    public void initialTotalIsZero() {
        Results results = new Results();
        assertThat(results.total.gross, equalTo(new BigDecimal("0")));
    }

    @Test
    public void totalsAddUp() {
        Results results = new Results();

        results.add(one);
        assertThat(results.total.gross, equalTo(new BigDecimal("2.50")));

        results.add(one);
        assertThat(results.total.gross, equalTo(new BigDecimal("5.00")));

    }

    @Test
    public void initialVatIsZero() {
        Results results = new Results();
        assertThat(results.total.vat, equalTo(new BigDecimal("0")));
    }

    @Test
    public void vatAddsUp() {
        Results results = new Results();

        results.add(one);
        results.add(one);

        assertThat(results.total.vat, equalTo(new BigDecimal("1.00")));
    }

    @Test
    public void resultJsonMatchesSpec() throws IOException {

        final String EXPECTED = Resources.toString(
                Resources.getResource(ResultsTest.class, "expected-total.json"),
                Charsets.UTF_8
        );

        Results results = new Results();
        results.add(one);

        final String ACTUAL = ResultSerializer.serialize(results);


        assertThat(ACTUAL, equalTo(EXPECTED));
    }

}
