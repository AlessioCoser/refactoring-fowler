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
}
