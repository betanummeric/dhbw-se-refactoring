package de.dhbw.se.refactoring;

class Rental {
    private Movie movie;
    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    int getDaysRented() {
        return daysRented;
    }

    Movie getMovie() {
        return movie;
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
}