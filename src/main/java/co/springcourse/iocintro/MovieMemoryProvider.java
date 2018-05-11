package co.springcourse.iocintro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class MovieMemoryProvider implements MovieProvider {

  private final List<Movie> movies;

  public MovieMemoryProvider() {
    movies = new ArrayList<>();
    movies.add(new Movie("Vertigo", "Alfred Hitchcock", "CRIME"));
    movies.add(new Movie("North by Northwest", "Alfred Hitchcock", "ACTION"));
    movies.add(new Movie("Psycho", "Alfred Hitchcock", "HORROR"));
    movies.add(new Movie("The Conversation", "Francis Ford Coppola", "CRIME"));
    movies.add(new Movie("Apocalypse Now", "Francis Ford Coppola", "ACTION"));
    movies.add(new Movie("The Godfather", "Francis Ford Coppola", "DRAMA"));
    movies.add(new Movie("Scarface", "Brian De Palma", "CRIME"));
    movies.add(new Movie("Carrie", "Brian De Palma", "HORROR"));
    movies.add(new Movie("Pulp Fiction", "Quentin Tarantino", "CRIME"));
    movies.add(new Movie("2001", "Stanley Kubrick", "SCI-FI"));
    movies.add(new Movie("The Shining", "Stanley Kubrick", "HORROR"));
    movies.add(new Movie("Full Metal Jacket", "Stanley Kubrick", "ACTION"));
    movies.add(new Movie("A Clockwork Orange", "Stanley Kubrick", "DRAMA"));
  }

  @Override
  public List<Movie> getMovies() {
    return Collections.unmodifiableList(movies);
  }

  @Override
  public List<Movie> filter(Predicate<Movie> predicate) {
    return movies.stream().filter(predicate).collect(Collectors.toList());
  }
}
