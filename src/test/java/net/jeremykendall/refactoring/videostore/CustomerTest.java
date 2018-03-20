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

    @Test
    public void NewReleasesRentalsForMoreThanOneDayShouldGiveBonusFrequentRenterPoints() {
        Customer customer = new Customer("customerName");
        Movie regularMovie = new Movie("movieTitle", Movie.NEW_RELEASE);

        customer.addRental(new Rental(regularMovie, 2));

        String expected = "Rental Record for customerName\n" +
                "\tmovieTitle\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void ChildrensMoviesForLessThanFourDaysShuoldCostOneAndHalf() {
        Customer customer = new Customer("customerName");
        Movie regularMovie = new Movie("movieTitle", Movie.CHILDRENS);

        customer.addRental(new Rental(regularMovie, 1));

        String expected = "Rental Record for customerName\n" +
                "\tmovieTitle\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void ChildrenMoviesForMoreThanThreeDaysShouldCostOneAndHalfPerDay() {
        Customer customer = new Customer("customerName");
        Movie regularMovie = new Movie("movieTitle", Movie.CHILDRENS);

        customer.addRental(new Rental(regularMovie, 4));

        String expected = "Rental Record for customerName\n" +
                "\tmovieTitle\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points";
        assertEquals(expected, customer.statement());
    }

    @Test
    public void ShouldOutputHtmlStatementForOneDayRentalOfRegularMovie() {
        Customer customer = new Customer("customerName");
        Movie regularMovie = new Movie("movieTitle", Movie.REGULAR);

        customer.addRental(new Rental(regularMovie, 1));

        String expected = "<H1>Rentals for <EM>customerName</EM></H1><P>\n" +
                "movieTitle: 2.0<BR>\n" +
                "<P>You owe <EM>2.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points</P>";
        assertEquals(expected, customer.htmlStatement());
    }
}
