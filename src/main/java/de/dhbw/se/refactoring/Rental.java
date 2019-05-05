package de.dhbw.se.refactoring;

class Rental {
    private final Movie movie;
    private final int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    double getPrice() {
        return movie.getPrice(daysRented);
    }

    int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }

    String print() {
        return String.format("\t%s\t\t%d\t%s\n", movie.getTitle(), daysRented, getPrice());
    }
}