package org.exoplatform.bch.predicateBuilder;

import org.exoplatform.bch.predicate.Activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by bdechateauvieux on 4/8/15.
 */
public class PredicateAdvancedBuilder {


    static final List<Activity> activities = new ArrayList<>();

    static {
        activities.add(new Activity("1st activity", 4, 10, new Date()));
        activities.add(new Activity("2nd activity", 0, 0, new Date()));
        activities.add(new Activity("3rd activity", 1, 76, new Date()));
        activities.add(new Activity("4th activity", 0, 76, new Date()));
        activities.add(new Activity("5th activity", 51, 76, new Date()));
        activities.add(new Activity("6th activity", 900, 76, new Date()));
    }

    public static void main(String... args) {
        PredicateAdvancedBuilder builder = new PredicateAdvancedBuilder();
        builder.filterLikedActivities();
    }





    private void filterLikedActivities() {
        Function<Integer, Predicate<Activity>> buildLikedActivitiesMatcher =
                minLikes -> (a -> a.getNbLikes() > minLikes);

        System.out.println(allMatches(activities, buildLikedActivitiesMatcher.apply(50)).size());
    }

    private List<Activity> allMatches(List<Activity> activities, Predicate<Activity> matcher) {
        List<Activity> result = new ArrayList<>();
        for (Activity activity: activities) {
            if (matcher.test(activity)) {
                result.add(activity);
            }
        }
        return result;
    }
}
