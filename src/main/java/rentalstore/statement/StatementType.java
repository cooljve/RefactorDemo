package rentalstore.statement;

import rentalstore.Rental;

import java.util.List;

public abstract class StatementType {
  public String statement(String name, List<Rental> rentals){
    double totalAmount = 0;
    int frequentRenterPoints = 0;
    String result = getHeader(name);
    for (Rental rental : rentals) {
      frequentRenterPoints++;
      int newReleaseThreshold = 1;
      boolean rentManyDay = rental.getDayRented() > newReleaseThreshold;
      if ((rental.isMovieNewRelease()) && rentManyDay) {
        frequentRenterPoints++;
      }
      result += getDetail(rental);
      totalAmount += rental.getTotalPrice();
    }
    result += getFooter(totalAmount, frequentRenterPoints);
    return result;
  }

  protected abstract String getFooter(double totalAmount, int frequentRenterPoints);
  protected abstract String getHeader(String name);
  protected abstract String getDetail(Rental rental);
}
