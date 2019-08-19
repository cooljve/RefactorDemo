package rentalstore.movieType;

public class NewReleaseMovie implements MovieType {
  @Override
  public double getTotalPrice(int dayRented) {
    double totalPrice = dayRented * 3;
    return totalPrice;
  }
}
