package de.dhbw.se.refactoring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void testCustomer() {
        String name = "Robin Rentsalot";

        Customer aCustomer = new Customer(name);
        assertEquals(name, aCustomer.getName());

        assertEquals("Rental Record for " + name + "\n" + "\tTitle\t\tDays\tAmount\n" + "Amount owed is 0.0\n" + "You"
                             + " earned 0 frequent renter points",
                     aCustomer.statement());

        Movie movieOne = new Movie("Mr. Bean", Movie.NEW_RELEASE);
        aCustomer.addRental(new Rental(movieOne, 0));
        assertEquals("Rental Record for " + name + "\n" + "\tTitle\t\tDays\tAmount\n" + "\t" + movieOne.getTitle() +
                             "\t\t0\t0.0\n" + "Amount owed is 0.0\n" + "You earned 1 frequent renter points",
                     aCustomer.statement());

        Movie movieTwo = new Movie("The Hundred-Year-Old Man Who Climbed Out the Window and Disappeared",
                                   Movie.REGULAR);
        aCustomer.addRental(new Rental(movieTwo, 5));
        assertEquals("Rental Record for " + name + "\n" + "\tTitle\t\tDays\tAmount\n" + "\t" + movieOne.getTitle() +
                             "\t\t0\t0.0\n" + "\t" + movieTwo.getTitle() + "\t\t5\t6.5\n" + "Amount owed is 6.5\n" +
                             "You earned 2 frequent renter points",
                     aCustomer.statement());

        Movie movieThree = new Movie("Ice Age", Movie.CHILDRENS);
        aCustomer.addRental(new Rental(movieThree, 42));
        assertEquals("Rental Record for " + name + "\n" + "\tTitle\t\tDays\tAmount\n" + "\t" + movieOne.getTitle() +
                             "\t\t0\t0.0\n" + "\t" + movieTwo.getTitle() + "\t\t5\t6.5\n" + "\t" + movieThree.getTitle() + "\t\t42\t60.0\n" + "Amount owed is 66.5\n" + "You earned 3 frequent renter points",
                     aCustomer.statement());
    }
}
