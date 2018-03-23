package net.jeremykendall.refactoring.videostore;

abstract class Price {
    public abstract double getCharge(int daysRented);

    public abstract int getPriceCode();

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}

class RegularPrice extends Price {
    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }

    public int getPriceCode() {
        return 0;
    }
}

class NewReleasePrice extends Price {
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    public int getPriceCode() {
        return 1;
    }

    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1)
            return 2;
        return 1;
    }
}

class ChildrenPrice extends Price {
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }

    public int getPriceCode() {
        return 2;
    }
}