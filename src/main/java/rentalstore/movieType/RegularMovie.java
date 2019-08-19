package rentalstore.movieType;

public class RegularMovie implements MovieType{

  @Override
  public double getTotalPrice(int dayRented) {
    double totalPrice = 2.0;
    if (dayRented > 2) {
      totalPrice += (dayRented - 2) * 1.5;
    }
    return totalPrice;
  }
}
