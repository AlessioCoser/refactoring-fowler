package net.jeremykendall.refactoring.videostore;

abstract class Price {
    public abstract double getCharge(int daysRented);
}

class RegularPrice extends Price {
    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
    }
}

class NewReleasePrice extends Price {
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }
}

class ChildrenPrice extends Price {
    public double getCharge(int daysRented) {
        double result = 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
    }
}