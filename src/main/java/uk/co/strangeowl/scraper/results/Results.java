package uk.co.strangeowl.scraper.results;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Results {

    List<Result> results = new ArrayList<>();
    Total total = new Total();

    public static class Total {

        static BigDecimal VAT = new BigDecimal("0.20");

        public BigDecimal gross = new BigDecimal(0);
        public BigDecimal vat = new BigDecimal(0);
    }

    public void add(Result result) {
        results.add(result);
        total.gross = total.gross.add(result.getUnitPrice());
        total.vat = total.gross.multiply(Total.VAT).setScale(2);
    }

}
