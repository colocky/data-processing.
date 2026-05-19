package com.pluralsight.loops;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        List<Person> matchingPeople = new ArrayList<>();

        for (Person person : people) {
            if (person.getFirstName().equalsIgnoreCase(searchName) || person.getLastName().equalsIgnoreCase(searchName)) {
                matchingPeople.add(person);
            }
        }

        System.out.println();
        System.out.println("Matching people:");

        if (matchingPeople.isEmpty()) {
            System.out.println("No matches found.");
        } else {
            for (Person person : matchingPeople) {
                System.out.println(person.getFullName());
            }
        }

        int totalAge = 0;
        int oldestAge = people.get(0).getAge();
        int youngestAge = people.get(0).getAge();

        for (Person person : people) {
            totalAge += person.getAge();

            if (person.getAge() > oldestAge) {
                oldestAge = person.getAge();
            }

            if (person.getAge() < youngestAge) {
                youngestAge = person.getAge();
            }
        }

        double averageAge = (double) totalAge / people.size();

        System.out.println();
        System.out.printf("Average age: %.1f%n", averageAge);
        System.out.println("Oldest age: " + oldestAge);
        System.out.println("Youngest age: " + youngestAge);

        scanner.close();
    }
}