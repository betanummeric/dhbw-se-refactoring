package de.dhbw.se.refactoring;

class RegularPriceCode extends PriceCode {

    @Override
    public double getPrice(int daysRented) {
        double rentalPrice = 2;
        if (daysRented > 2) {
            rentalPrice += (daysRented - 2) * 1.5;
        }
        return rentalPrice;
    }

}
