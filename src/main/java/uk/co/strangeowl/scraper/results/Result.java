package uk.co.strangeowl.scraper.results;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class Result {

    private String title;
    private Integer kiloCaloriesPerHundredGrams;
    private BigDecimal unitPrice;
    private String description;


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
