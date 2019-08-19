package rentalstore.factory;

import rentalstore.Movie;
import rentalstore.movieType.ChildrenMovie;
import rentalstore.movieType.MovieType;
import rentalstore.movieType.NewReleaseMovie;
import rentalstore.movieType.RegularMovie;

public class MovieTypeFactory {
  public static MovieType create(int type) {
    switch (type) {
      case Movie.REGULAR:
        return new RegularMovie();
      case Movie.NEW_RELEASE:
        return new NewReleaseMovie();
      case Movie.CHILDRENS:
        return new ChildrenMovie();
    }
    throw new IllegalArgumentException();
  }
}
