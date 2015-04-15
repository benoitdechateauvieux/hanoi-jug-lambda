package org.exoplatform.bch.predicateBuilder;

import org.exoplatform.bch.predicate.Activity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by bdechateauvieux on 4/8/15.
 */
public class PredicateBuilder {


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
        PredicateBuilder builder = new PredicateBuilder();
        builder.filterLikedActivities().forEach(a -> System.out.println(a));
    }




    //Build the predicate from a parameter
    private Predicate<Activity> getLikedActivitiesPredicate(String tenantName) {
        //... make computation here
        int minLikes = Tenant.getByName(tenantName).getMinLikes();
        //return predicate (lambda)
        return a -> a.getNbLikes() > minLikes;
    }


    private List<Activity> filterLikedActivities() {
        //Build the predicate
        Predicate<Activity> likedActivitiesMatcher = getLikedActivitiesPredicate("isd-7896");
        //Use the predicate
        return allMatches(activities, likedActivitiesMatcher);
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
