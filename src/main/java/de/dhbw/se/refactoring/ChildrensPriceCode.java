package de.dhbw.se.refactoring;

public class ChildrensPriceCode extends PriceCode {

    @Override
    public double getPrice(int daysRented) {
        double rentalPrice = 1.5;
        if (daysRented > 3) {
            rentalPrice += (daysRented - 3) * 1.5;
        }
        return rentalPrice;
    }

}
