package de.dhbw.se.refactoring;

import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    void addRental(Rental rental) {
        rentals.add(rental);
    }

    String getName() {
        return name;
    }

    String statement() {
        double totalPrice = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\tTitle\t\tDays\tAmount\n";

        for (Rental rental : rentals) {
            double rentalPrice = 0;

            //determine amounts for each line
            rentalPrice = rental.getPrice();

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            //show figures for this rental
            result += String.format("\t%s\t\t%d\t%s\n",
                                    rental.getMovie().getTitle(),
                                    rental.getDaysRented(),
                                    rentalPrice);
            totalPrice += rentalPrice;
        }

        //add footer lines
        result += String.format("Amount owed is %s\n", totalPrice);
        result += String.format("You earned %d frequent renter points", frequentRenterPoints);
        return result;
    }

}