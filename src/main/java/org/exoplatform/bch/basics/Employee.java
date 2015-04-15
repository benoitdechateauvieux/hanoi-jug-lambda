package org.exoplatform.bch.basics;

/**
 * Created by bdechateauvieux on 4/14/15.
 */
public class Employee {
    Integer id;
    String firstName;
    String lastName;
    Double salary;

    Employee() {}
    Employee(int id, String first, String last, Double salary) {
        this.id = id;
        this.firstName = first;
        this.lastName = last;
        this.salary = salary;
    }

    public String toString() {
        return "" + id + ", " + firstName + ", " + lastName + ", " + salary;
    }
}
