package rentalstore.movieType;

public class ChildrenMovie implements MovieType {
  @Override
  public double getTotalPrice(int dayRented) {
    double totalPrice = 1.5;
    if (dayRented > 3) {
      totalPrice += (dayRented - 3) * 1.5;
    }
    return totalPrice;
  }
}
