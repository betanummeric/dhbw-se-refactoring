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
            rentalPrice = rentalPriceFor(rental);
            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental
            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1) {
                frequentRenterPoints++;
            }
            //show figures for this rental
            result += String.format("\t%s\t\t%d\t%s\n", rental.getMovie().getTitle(), rental.getDaysRented(), rentalPrice);
            totalPrice += rentalPrice;
        }
        //add footer lines
        result += String.format("Amount owed is %s\n", totalPrice);
        result += String.format("You earned %d frequent renter points", frequentRenterPoints);
        return result;
    }

    private double rentalPriceFor(Rental rental) {
        double rentalPrice = 0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalPrice += 2;
                if (rental.getDaysRented() > 2) rentalPrice += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalPrice += rental.getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                rentalPrice += 1.5;
                if (rental.getDaysRented() > 3) rentalPrice += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return rentalPrice;
    }

}