package de.dhbw.se.refactoring;

class Rental {
    private Movie movie;
    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    double getPrice() {
        double rentalPrice = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                rentalPrice += 2;
                if (daysRented > 2) rentalPrice += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalPrice += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                rentalPrice += 1.5;
                if (daysRented > 3) rentalPrice += (daysRented - 3) * 1.5;
                break;
        }
        return rentalPrice;
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