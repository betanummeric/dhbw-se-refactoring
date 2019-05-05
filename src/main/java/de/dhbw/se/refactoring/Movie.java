package de.dhbw.se.refactoring;

public class Movie {
    static final PriceCode CHILDRENS = new ChildrensPriceCode();
    static final PriceCode REGULAR = new RegularPriceCode();
    static final PriceCode NEW_RELEASE = new NewReleasePriceCode();

    private final String title;
    private final PriceCode priceCode;

    Movie(String title, PriceCode priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    String getTitle() {
        return title;
    }

    double getPrice(int daysRented){
        return priceCode.getPrice(daysRented);
    }

    int getFrequentRenterPoints(int daysRented){
        return priceCode.getFrequentRenterPoints(daysRented);
    }

}