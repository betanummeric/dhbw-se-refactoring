package de.dhbw.se.refactoring;

class Rental {
    private Movie movie;
    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    double getPrice() {
        return movie.getPriceCode().getPrice(daysRented);
    }

    int getFrequentRenterPoints() {
        return movie.getPriceCode().getFrequentRenterPoints(daysRented);
    }

    String print() {
        return String.format("\t%s\t\t%d\t%s\n", movie.getTitle(), daysRented, getPrice());
    }
}