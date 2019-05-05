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
        StringBuilder result = new StringBuilder("Rental Record for " + this.getName() + "\n");
        result.append("\tTitle\t\tDays\tAmount\n");

        for (Rental rental : rentals) {
            //show figures for this rental
            result.append(rental.print());
        }

        //add footer lines
        result.append(String.format("Amount owed is %s\n", getTotalPrice()));
        result.append(String.format("You earned %d frequent renter points", getFrequentRenterPoints()));
        return result.toString();
    }

    private int getFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }

    private double getTotalPrice(){
        return rentals.stream().mapToDouble(Rental::getPrice).sum();
    }
}