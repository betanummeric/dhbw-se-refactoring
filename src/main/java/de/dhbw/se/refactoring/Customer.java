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
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\tTitle\t\tDays\tAmount\n";

        for (Rental rental : rentals) {
            //show figures for this rental
            result += String.format("\t%s\t\t%d\t%s\n",
                                    rental.getMovie().getTitle(),
                                    rental.getDaysRented(),
                                    rental.getPrice());
        }

        //add footer lines
        result += String.format("Amount owed is %s\n", getTotalPrice());
        result += String.format("You earned %d frequent renter points", getFrequentRenterPoints());
        return result;
    }

    private int getFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::getFrequentRenterPoints).sum();
    }

    private double getTotalPrice(){
        double totalPrice = 0;
        for (Rental rental : rentals) {
            totalPrice += rental.getPrice();

        }
        return totalPrice;
    }
}