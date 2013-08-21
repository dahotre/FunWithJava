import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO Write purpose of Type
 *
 * @author adahotre
 * @see TODO
 */
public class Chapter2_Collections {
  public static void main(String[] args) {
    List<String> names = Arrays.asList("wayne", "james", "hector");

    /**
     * ITERATION
     */

    //Old way
    for (String name : names) {
      System.out.println(name);
    }

    //Using Consumer
    names.forEach(new Consumer<String>() {
      @Override
      public void accept(String s) {
        System.out.println(s);
      }
    });

    //Using Lambda
    names.forEach((final String name) -> System.out.println(name));

    //Lambda with type inference
    names.forEach((name) -> System.out.println(name));

    //Lambda with type inference.. remove paranthesis around name
    names.forEach(name -> System.out.println(name));

    //Lambda with method reference
    names.forEach(System.out::println);

    /**
     * MAP
     */
    names.stream()
        .map(name -> name.toUpperCase())
        .forEach(System.out::println);

    //Using method reference in map
    names.stream()
        .map(String::toUpperCase)
        .forEach(System.out::println);

    /**
     * FILTER
     */
    final List<String> namesStartingWithJ = names.stream()
        .filter(name -> name.startsWith("j"))
        .collect(Collectors.toList());
    namesStartingWithJ.forEach(System.out::println);

    /**
     * PREDICATES
     */
    final Predicate<String> startsWithj = name -> name.startsWith("j");
    Stream<String> namesStartingWithjUsingPredicate = names.stream().filter(startsWithj);
    namesStartingWithjUsingPredicate.forEach(System.out::println);

  }
}
