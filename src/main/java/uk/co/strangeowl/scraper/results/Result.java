package uk.co.strangeowl.scraper.results;

import java.math.BigDecimal;

public class Result {

    private String title;
    private String description;
    private BigDecimal unitPrice;

    private Integer kiloCaloriesPerHundredGrams;


    public Result(String title, String description, BigDecimal unitPrice) {
        this(title, description,unitPrice, null);
    }

    public Result(String title, String description, BigDecimal unitPrice, Integer kiloCaloriesPerHundredGrams) {
        this.title = title;
        this.description = description;
        this.unitPrice = unitPrice;
        this.kiloCaloriesPerHundredGrams = kiloCaloriesPerHundredGrams;
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

    public Integer getKiloCaloriesPerHundredGrams() {
        return kiloCaloriesPerHundredGrams;
    }
}
