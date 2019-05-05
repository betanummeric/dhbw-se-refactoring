package de.dhbw.se.refactoring;

public class Movie {
    static final PriceCode CHILDRENS = new ChildrensPriceCode();
    static final PriceCode REGULAR = new RegularPriceCode();
    static final PriceCode NEW_RELEASE = new NewReleasePriceCode();

    private String title;
    private PriceCode priceCode;

    Movie(String title, PriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    PriceCode getPriceCode() {
        return priceCode;
    }

    String getTitle() {
        return title;
    }

}