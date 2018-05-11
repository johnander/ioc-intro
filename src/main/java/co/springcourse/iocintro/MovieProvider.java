package co.springcourse.iocintro;

import java.util.List;
import java.util.function.Predicate;

public interface MovieProvider {

  List<Movie> getMovies();

  List<Movie> filter(Predicate<Movie> predicate);
}
