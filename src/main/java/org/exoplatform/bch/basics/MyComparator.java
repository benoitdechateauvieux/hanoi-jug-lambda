package org.exoplatform.bch.basics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by bdechateauvieux on 4/14/15.
 */
public class MyComparator {
    private static List<User> users = Arrays.asList(
            new User(1, "Steve", "Vai", 40),
            new User(4, "Joe", "Smith", 32),
            new User(3, "Steve", "Johnson", 57),
            new User(9, "Mike", "Stevens", 18),
            new User(10, "George", "Armstrong", 24),
            new User(2, "Jim", "Smith", 40),
            new User(8, "Chuck", "Schneider", 34),
            new User(5, "Jorje", "Gonzales", 22),
            new User(6, "Jane", "Michaels", 47),
            new User(7, "Kim", "Berlie", 60)
    );

    public static void main(String[] args) {

        // Without Lambda (Anonymous Class)
        Collections.sort(users, new Comparator<User>() {
            public int compare(User u1, User u2) {
                return u1.age.compareTo(u2.age);
            }
        });

        // Lambda
        Collections.sort(users, (User u1, User u2) -> u1.age.compareTo(u2.age));
    }

}
