package org.exoplatform.bch.basics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by bdechateauvieux on 4/14/15.
 */
public class BehaviourAndData {
    private static List<Employee> employees = Arrays.asList(
            new Employee(1, "Steve", "Vai", 40.0),
            new Employee(4, "Joe", "Smith", 32.0),
            new Employee(3, "Steve", "Johnson", 57.0),
            new Employee(9, "Mike", "Stevens", 18.0),
            new Employee(10, "George", "Armstrong", 24.0),
            new Employee(2, "Jim", "Smith", 40.0),
            new Employee(8, "Chuck", "Schneider", 34.0),
            new Employee(5, "Jorje", "Gonzales", 22.0),
            new Employee(6, "Jane", "Michaels", 47.0),
            new Employee(7, "Kim", "Berlie", 60.0)
    );

    private static void updateSalary(List<Employee> employees, Consumer<Employee> salaryUpdate) {
        employees.forEach(salaryUpdate);
    }

    public static void main(String... args) {
        employees.forEach(emp -> System.out.println(emp));


        //           data       behavior
        updateSalary(employees, emp -> emp.salary *= 1.2);




        System.out.println("#####");
        employees.forEach(emp -> System.out.println(emp));
    }
}
