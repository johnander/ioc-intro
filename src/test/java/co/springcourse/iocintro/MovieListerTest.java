package co.springcourse.iocintro;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class MovieListerTest {

  @Test
  public void memoryProvider() {
    MovieLister movieLister = new MovieLister(IoC.movieProviderFactory(MovieProvidersId.MEMORY));
    List<Movie> allMovies = movieLister.findAll();

    assertAll(
        () -> assertEquals(13, allMovies.size()),
        () -> assertEquals("Vertigo", allMovies.get(0).getTitle())
    );
  }

  @Test
  public void csvProvider() {
    MovieLister movieLister = new MovieLister(IoC.movieProviderFactory(MovieProvidersId.CSV));
    List<Movie> allMovies = movieLister.findAll();

    assertAll(
        () -> assertEquals(175, allMovies.size()),
        () -> assertEquals("Psycho", allMovies.get(150).getTitle())
    );
  }
}