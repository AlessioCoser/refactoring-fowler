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
    public void OneRegularMovieForLessThanTwoDaysShouldOweTwo() {
        Customer customer = new Customer("customerName");
        Movie regularMovie = new Movie("movieTitle", Movie.REGULAR);

        customer.addRental(new Rental(regularMovie, 1));

        String expected = "Rental Record for customerName\n" +
                "\tmovieTitle\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void OneRegularMovieForMoreThanTwoDaysShouldAddOneAndHalfADay() {
        Customer customer = new Customer("customerName");
        Movie regularMovie = new Movie("movieTitle", Movie.REGULAR);

        customer.addRental(new Rental(regularMovie, 3));

        String expected = "Rental Record for customerName\n" +
                "\tmovieTitle\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void NewReleasesShouldCostThreeForOneDay() {
        Customer customer = new Customer("customerName");
        Movie regularMovie = new Movie("movieTitle", Movie.NEW_RELEASE);

        customer.addRental(new Rental(regularMovie, 1));

        String expected = "Rental Record for customerName\n" +
                "\tmovieTitle\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }
}
