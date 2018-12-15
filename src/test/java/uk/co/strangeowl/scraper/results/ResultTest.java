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

    final int CALORIES = 100;

    private Result result = new Result(
            TITLE,
            DESCRIPTION,
            PRICE,
            CALORIES
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
        Result result = new Result(TITLE, DESCRIPTION, PRICE);
       assertThat(result.getKiloCaloriesPerHundredGrams(), equalTo(null));
    }

    @Test
    public void resultCanHaveKiloCalories() {
        assertThat(result.getKiloCaloriesPerHundredGrams(), equalTo(100));
    }

}
