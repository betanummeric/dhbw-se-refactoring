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
        // add bonus for a two day new release rental
        if ((movie.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1) {
            return 2;
        }

        return 1;
    }

    String print() {
        return String.format("\t%s\t\t%d\t%s\n", movie.getTitle(), daysRented, getPrice());
    }
}