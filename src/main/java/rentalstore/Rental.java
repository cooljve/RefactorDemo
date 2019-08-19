package rentalstore;

import rentalstore.factory.MovieTypeFactory;
import rentalstore.movieType.ChildrenMovie;
import rentalstore.movieType.MovieType;
import rentalstore.movieType.NewReleaseMovie;
import rentalstore.movieType.RegularMovie;

public class Rental {
  private Movie movie;
  private MovieType movieType = null;
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

  public String generateDetail() {
    return "\t" + movie.getTitle() + "\t" + getTotalPrice() + "\n";
  }

  public boolean isMovieNewRelease() {
    return movie.getPriceCode() == Movie.NEW_RELEASE;
  }

  public int getDayRented() {
    return dayRented;
  }
}
