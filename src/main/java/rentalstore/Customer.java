package rentalstore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = generateHeader();
        for (Rental rental : this.rentals) {
            double thisAmount = rental.getTotalPrice();

            frequentRenterPoints++;

            int newReleaseThreshold = 1;
            if ((rental.isMovieNewRelease()) && rental.getDayRented() > newReleaseThreshold) {
                frequentRenterPoints++;
            }

            //show figures for this rental
            result += rental.generateDetail();
            totalAmount += thisAmount;
        }

        //add footer lines
        result += getFooter(totalAmount, frequentRenterPoints);
        return result;
    }

    private String getFooter(double totalAmount, int frequentRenterPoints) {
        return "Amount owed is " + totalAmount + "\n" + "You earned " + frequentRenterPoints + " frequent renter points";
    }

    private String generateHeader() {
        return "Rental Record for " + getName() + "\n";
    }
}
