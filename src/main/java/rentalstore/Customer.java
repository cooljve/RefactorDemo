package rentalstore;

import rentalstore.statement.HtmlStatement;
import rentalstore.statement.RegularStatement;

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

    public String generateRegularStatement() {
      String statement = new RegularStatement().statement(name, this.rentals);
      return statement;
    }

    public String generateHtmlStatement() {
      String statement = new HtmlStatement().statement(name, this.rentals);
      return statement;
    }
}
