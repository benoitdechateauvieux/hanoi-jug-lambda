package org.exoplatform.bch.sort;

import java.util.*;

/**
 * Created by bdechateauvieux on 3/30/15.
 */
public class ComposedSorter {
    private static List<User> users = Arrays.asList(
            new User(1, "Steve", "Vai", 40),
            new User(4, "Joe", "Smith", 32),
            new User(3, "Steve", "Johnson", 57),
            new User(9, "Mike", "Stevens", 18),
            new User(10, "George", "Armstrong", 24),
            new User(2, "Jim", "Smith", 40),
            new User(8, "Chuck", "Schneider", 34),
            new User(5, "AJorje", "AGonzales", 22),
            new User(6, "ZJane", "ZMichaels", 22),
            new User(7, "Kim", "Berlie", 60)
    );

    public static void main(String[] args) {

        // Lambda
        Comparator<User> byAge  = (u1, u2) -> u1.age.compareTo(u2.age);
        Comparator<User> byName = (u1, u2) -> u1.firstName.compareTo(u2.firstName);

        Collections.sort(users, byAge.thenComparing(byName.reversed()));

    }
}
