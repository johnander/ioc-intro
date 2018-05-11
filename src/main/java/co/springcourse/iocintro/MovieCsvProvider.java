package co.springcourse.iocintro;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public final class MovieCsvProvider implements MovieProvider {

  private final String csvFilePath;
  private final char delimiter;
  private final List<Movie> movies = new ArrayList<>();


  public MovieCsvProvider(final String csvFilePath, final char delimiter) {
    this.csvFilePath = csvFilePath;
    this.delimiter = delimiter;
    init();
  }

  private void init() {
    System.out.println("Initializing movies data from csv file");
    try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(csvFilePath)) {
      Reader reader = new InputStreamReader(inputStream);
      Iterable<CSVRecord> records =
          CSVFormat.EXCEL.withDelimiter(delimiter).withFirstRecordAsHeader().parse(reader);
      records.forEach(record -> {
        String title = record.get("Film");
        String director = record.get("Director");
        String genre = record.get("Genre");
        movies.add(new Movie(title, director, genre));
      });
    } catch (IOException e) {
      e.printStackTrace();
    }
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
