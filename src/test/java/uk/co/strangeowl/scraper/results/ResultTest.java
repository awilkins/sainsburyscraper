package uk.co.strangeowl.scraper.results;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class ResultTest {

    final String TITLE = "Sainsbury's Strawberries";
    final String DESCRIPTION = "Delicious, juicy, strawberries";

    // Using BigDecimal here to avoid floating-point errors on currency
    final BigDecimal PRICE = new BigDecimal("1.75");

    private Result result = new Result(
            TITLE,
            DESCRIPTION,
            PRICE
    );

    @Test
    public void resultHasTitle() {
        assertThat(result.getTitle(), equalTo(TITLE));
    }

    @Test
    public void resultHasDescription() {
        assertThat(result.getDescription(), equalTo(DESCRIPTION));
    }

    @Test
    public void resultHasUnitPrice() {
        assertThat(result.getUnitPrice(), equalTo(PRICE));
    }

    @Test
    public void kiloCaloriesAreOptional() {
       assertThat(result.getKiloCaloriesPerHundredGrams(), equalTo(null));
    }

    @Test
    public void kiloCaloriesCanHappen() {
        Result result = new Result(TITLE, DESCRIPTION, PRICE, 100);
        assertThat(result.getKiloCaloriesPerHundredGrams(), equalTo(100));
    }

}
