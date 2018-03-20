package net.jeremykendall.refactoring.videostore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {
    @Test
    public void AmountOwedShouldBeZeroIfNoMoviesAreRented() {
        Customer customer = new Customer("customerName");
        String expected = "Rental Record for customerName\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void OneRegularMovieForOneDayShouldOweTwo() {
        Customer customer = new Customer("customerName");
        Movie regularMovie = new Movie("movieTitle", Movie.REGULAR);

        customer.addRental(new Rental(regularMovie, 1));

        String expected = "Rental Record for customerName\n" +
                "\tmovieTitle\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }
}
