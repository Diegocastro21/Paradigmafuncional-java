import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    List<Person> people = getPeople();

    // Imperative approach ❌

    /*

    List<Person> females = new ArrayList<>();

    for (Person person : people) {

      if (person.getGender().equals(Gender.FEMALE)) {
        females.add(person);
      }
    }

    females.forEach(System.out::println);

    */

    // Declarative approach ✅

    // Filter
    List<Person> females = people.stream()
        .filter(person -> person.getGender().equals(Gender.FEMALE))
        .collect(Collectors.toList());

    females.forEach(System.out::println);


    // Sort
    List<Person> sorted = people.stream()
        .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
        .collect(Collectors.toList());

    sorted.forEach(System.out::println);

    // All match
    boolean allMatch = people.stream()
        .allMatch(person -> person.getAge() > 8);

    System.out.println(allMatch);

    // Any match
    boolean anyMatch = people.stream()
        .anyMatch(person -> person.getAge() > 121);

    System.out.println(anyMatch);


    // None match
    boolean noneMatch = people.stream()
        .noneMatch(person -> person.getName().equals("Antonio"));

    System.out.println(noneMatch);


    // Max
    people.stream()
        .max(Comparator.comparing(Person::getAge))
        .ifPresent(System.out::println);

    System.out.println("\n\n");
    // Min
    people.stream()
        .min(Comparator.comparing(Person::getAge))
        .ifPresent(System.out::println);


    // Group
    Map<Gender, List<Person>> groupByGender = people.stream()
        .collect(Collectors.groupingBy(Person::getGender));

    groupByGender.forEach((gender, people1) -> {
      System.out.println(gender);
      people1.forEach(System.out::println);
      System.out.println();
    });

    Optional<String> oldestFemaleAge = people.stream()
        .filter(person -> person.getGender().equals(Gender.MALE))
        .max(Comparator.comparing(Person::getAge))
        .map(Person::getName);

    oldestFemaleAge.ifPresent(System.out::println);
  }

  private static List<Person> getPeople() {
    return List.of(
        new Person("Antonio Narino", 20, Gender.MALE),
        new Person("Gustavito Petroski", 33, Gender.FEMALE),
        new Person("Alvarito paraco", 57, Gender.FEMALE),
        new Person("Fico chirrete", 14, Gender.MALE),
        new Person("Pato donald",40, Gender.BINARY),
        new Person("Rodolfo peluca", 99, Gender.MALE),
        new Person("Francie Merquez", 7, Gender.FEMALE),
        new Person("Pato donald",40, Gender.BINARY),
        new Person("Pato donald",40, Gender.BINARY),
        new Person("Vicky chisme", 120, Gender.FEMALE)
    );
  }

}
