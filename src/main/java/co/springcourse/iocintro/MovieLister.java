package co.springcourse.iocintro;

import java.util.List;

public final class MovieLister {

  private MovieProvider movieProvider;

  public MovieLister(final MovieProvider movieProvider) {
    this.movieProvider = movieProvider;
  }

  public List<Movie> findAll() {
    return movieProvider.getMovies();
  }

  public List<Movie> findByDirector(final String director) {
    return movieProvider.filter(movie -> movie.getDirector().equalsIgnoreCase(director));
  }
}
