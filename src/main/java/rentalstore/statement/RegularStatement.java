package rentalstore.statement;

import rentalstore.Rental;

import java.util.List;

public class RegularStatement extends StatementType {

  public String getFooter(double totalAmount, int frequentRenterPoints) {
    return "Amount owed is " + totalAmount + "\n" + "You earned " + frequentRenterPoints + " frequent renter points";
  }

  public String getHeader(String name) {
    return "Rental Record for " + name + "\n";
  }

  @Override
  public String getDetail(Rental rental) {
    return "\t" + rental.getTitle() + "\t" + rental.getTotalPrice() + "\n";
  }
}
