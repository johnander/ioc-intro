package co.springcourse.iocintro;

public class Main {

  public static void main(String[] args) {

    MovieProvider movieProvider = IoC.movieProviderFactory(MovieProvidersId.CSV);
    // IoC: Lifecycle init() / start()
    IoC.invokePostConstruct(movieProvider);

    // CDI: Constructor Dependency Injection
    MovieLister lister = new MovieLister(movieProvider);

    System.out.println("All movies:");
    lister.findAll().forEach(System.out::println);
    System.out.println("-----------------------------");
    System.out.println("Only Kubrick:");
    lister.findByDirector("Stanley Kubrick").forEach(System.out::println);

    // IoC: Lifecycle destroy() / stop()
    IoC.invokePreDestroy(movieProvider);
  }
}
