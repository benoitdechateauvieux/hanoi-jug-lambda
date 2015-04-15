package org.exoplatform.bch.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by bdechateauvieux on 3/30/15.
 */
public class LambdaSorter {

    private final List<Person> persons;

    public LambdaSorter() {
        persons = new ArrayList<>();
        Random rand = new Random();
        for (int i=0; i<10; i++) {
            persons.add(new Person(rand.nextInt(100)));
        }
    }

    private class Person {
        private final int age;

        public Person(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

    private void sort() {
        persons.sort((person1, person2) -> person1.getAge()>person2.getAge()?1:-1);
    }

    private void print() {
        for(Person person:persons) {
            System.out.print(person.getAge() + " ");
        }
        System.out.println();
    }

    public static void main(String... args) {
        LambdaSorter sorter = new LambdaSorter();
        sorter.print();
        sorter.sort();
        sorter.print();
    }
}
