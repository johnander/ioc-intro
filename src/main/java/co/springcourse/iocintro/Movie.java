package co.springcourse.iocintro;

public final class Movie {

  private String title;
  private String director;
  private String genre;

  public Movie(final String title, final String director, final String genre) {
    this.title = title;
    this.director = director;
    this.genre = genre;
  }

  public String getTitle() {
    return title;
  }

  public String getDirector() {
    return director;
  }

  public String getGenre() {
    return genre;
  }

  @Override
  public String toString() {
    return "Movie{" +
        "title='" + title + '\'' +
        ", director='" + director + '\'' +
        ", genre='" + genre + '\'' +
        '}';
  }
}
