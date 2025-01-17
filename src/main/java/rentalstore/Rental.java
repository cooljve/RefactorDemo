package rentalstore;

import rentalstore.factory.MovieTypeFactory;
import rentalstore.movieType.MovieType;

public class Rental {
  private Movie movie;
  private MovieType movieType;
  private int dayRented;

  public Rental(Movie movie, int dayRented) {
    this.movie = movie;
    this.dayRented = dayRented;
    this.movieType = MovieTypeFactory.create(movie.getPriceCode());
  }

  public double getTotalPrice() {
    double totalPrice = movieType.getTotalPrice(dayRented);
    return totalPrice;
  }

  public boolean isMovieNewRelease() {
    return movie.getPriceCode() == Movie.NEW_RELEASE;
  }

  public int getDayRented() {
    return dayRented;
  }

  public String getTitle() {
    return movie.getTitle();
  }
}
