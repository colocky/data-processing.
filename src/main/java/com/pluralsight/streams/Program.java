    package com.pluralsight.streams;

    import com.pluralsight.Person;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Scanner;
    import java.util.stream.Collectors;

    public class Program {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            List<Person> people = new ArrayList<>();

            people.add(new Person("Emma", "Johnson", 28));
            people.add(new Person("Liam", "Smith", 34));
            people.add(new Person("Olivia", "Brown", 22));
            people.add(new Person("Noah", "Davis", 41));
            people.add(new Person("Ava", "Wilson", 19));
            people.add(new Person("Elijah", "Miller", 55));
            people.add(new Person("Sophia", "Moore", 31));
            people.add(new Person("James", "Taylor", 47));
            people.add(new Person("Mia", "Anderson", 26));
            people.add(new Person("Lucas", "Thomas", 63));

            System.out.print("Enter a first or last name to search: ");
            String searchName = scanner.nextLine();

            List<Person> matchingPeople = people.stream()
                    .filter(person -> person.getFirstName().equalsIgnoreCase(searchName)
                            || person.getLastName().equalsIgnoreCase(searchName))
                    .collect(Collectors.toList());

            System.out.println();
            System.out.println("Matching people:");

            if (matchingPeople.isEmpty()) {
                System.out.println("No matches found.");
            } else {
                matchingPeople.stream()
                        .map(Person::getFullName)
                        .forEach(System.out::println);
            }

            int totalAge = people.stream()
                    .map(Person::getAge)
                    .reduce(0, (total, age) -> total + age);

            double averageAge = (double) totalAge / people.size();

            int oldestAge = people.stream()
                    .map(Person::getAge)
                    .reduce(people.get(0).getAge(), (oldest, age) -> {
                        if (age > oldest) {
                            return age;
                        } else {
                            return oldest;
                        }
                    });

            int youngestAge = people.stream()
                    .map(Person::getAge)
                    .reduce(people.get(0).getAge(), (youngest, age) -> {
                        if (age < youngest) {
                            return age;
                        } else {
                            return youngest;
                        }
                    });

            System.out.println();
            System.out.printf("Average age: %.1f%n", averageAge);
            System.out.println("Oldest age: " + oldestAge);
            System.out.println("Youngest age: " + youngestAge);

            scanner.close();
        }
    }