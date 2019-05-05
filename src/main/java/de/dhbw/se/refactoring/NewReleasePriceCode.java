package de.dhbw.se.refactoring;

public class NewReleasePriceCode implements PriceCode {

    @Override
    public double getPrice(int daysRented) {
        return daysRented * 3;
    }

}
