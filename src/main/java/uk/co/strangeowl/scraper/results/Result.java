package uk.co.strangeowl.scraper.results;

import java.math.BigDecimal;

public class Result {

    private String title;
    private String description;
    private BigDecimal unitPrice;

    public Result(String title, String description, BigDecimal unitPrice) {
        this.title = title;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
}
