package de.dhbw.se.refactoring;

abstract class PriceCode {
    abstract double getPrice(int daysRented);

    int getFrequentRenterPoints(int daysRented){
        return 1;
    }
}
