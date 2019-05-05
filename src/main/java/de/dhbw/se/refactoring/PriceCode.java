package de.dhbw.se.refactoring;

public interface PriceCode {
    double getPrice(int daysRented);
    int getFrequentRenterPoints(int daysRented);
}
