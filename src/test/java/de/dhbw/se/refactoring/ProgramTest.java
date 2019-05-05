package de.dhbw.se.refactoring;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ProgramTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
    private final PrintStream standardOutputStream = System.out;
    private final PrintStream standardErrorStream = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
        System.setErr(new PrintStream(errorStream));
    }

    @After
    public void restoreStreams() {
        System.setOut(standardOutputStream);
        System.setErr(standardErrorStream);
    }

    @Test
    public void testMain() {
        Program.main(new String[]{});
        assertEquals("Welcome to the Movie Store\n" + "Let's get the Statement\n" + "Rental Record for joe\n" +
                             "\tTitle\t\tDays\tAmount\n" + "\tmovie1\t\t10\t30.0\n" + "\tmovie2\t\t5\t4.5\n" +
                             "Amount owed is 34.5\n" + "You earned 3 frequent renter points\n",
                     outputStream.toString());
        assertEquals("", errorStream.toString());
    }
}
