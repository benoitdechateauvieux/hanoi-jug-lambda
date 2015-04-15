package org.exoplatform.bch.effectivelyfinal;

import java.util.Arrays;
import java.util.List;

/**
 * Created by bdechateauvieux on 4/14/15.
 */
public class TestEffectivelyFinal {
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

    private void raiseSalary(List<Employee> employees, Double raise) {
        // raise variable is not marked as final but is "effectively final"
        employees.forEach(emp -> emp.salary += raise);
    }


    private void raiseSalaryForDevs(List<Employee> employees, Double raise) {
        // raise variable is not marked as final
        raise = raise * 2;
        // as its value has been changed,
        // it is not considered "effectively final" by the compiler
        // It cannot be used in the lambda
//        employees.forEach(emp -> emp.salary += raise);
    }






    public static void main(String[] args) {
        TestEffectivelyFinal test = new TestEffectivelyFinal();
        employees.forEach(u -> System.out.println(u));
        test.raiseSalary(employees, 10.0);
        employees.forEach(u -> System.out.println(u));
    }
}
