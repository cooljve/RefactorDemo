package rentalstore.statement;

import rentalstore.Rental;

import java.util.List;

public class HtmlStatement extends StatementType {

  public String getHeader(String name) {
    return "<H1>Rentals for <EM>" + name + "</EM></H1><P>\n";
  }

  public String getDetail(Rental rental) {
    return rental.getTitle() + ": " + rental.getTotalPrice() + "<BR>";
  }

  public String getFooter(double totalAmount, int frequentRenterPoints) {
    return "</P>\n<P>You owe<EM>" + totalAmount + "</EM><P>\n" +
        "On this rental you earned <EM>" + frequentRenterPoints + "</EM> frequent renter points<P>";
  }
}
