package co.springcourse.iocintro;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public final class IoC {

  private static void invokeAnnotatedMethod(Object component,
      Class<? extends Annotation> annotation) {
    for (Method method : component.getClass().getDeclaredMethods()) {
      if (method.isAnnotationPresent(annotation)) {
        try {
          method.invoke(component);
          return;
        } catch (IllegalAccessException | InvocationTargetException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static void invokePostConstruct(Object component) {
    invokeAnnotatedMethod(component, PostConstruct.class);
  }

  public static void invokePreDestroy(Object component) {
    invokeAnnotatedMethod(component, PreDestroy.class);
  }

  public static MovieProvider movieProviderFactory(MovieProvidersId providerId) {
    switch (providerId) {
      case MEMORY:
        throw new UnsupportedOperationException("Implement Memory Provider");
      case CSV:
        // IoC: Configuration
        return new MovieCsvProvider("ALL-MOVIES.csv", ';');
    }
    throw new IllegalArgumentException();
  }
}
