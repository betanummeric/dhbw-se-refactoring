package de.dhbw.se.refactoring;

class NewReleasePriceCode extends PriceCode {

    @Override
    public double getPrice(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        // add bonus for a two day new release rental
        if (daysRented > 1) {
            return 2;
        } else {
            return 1;
        }
    }

}
