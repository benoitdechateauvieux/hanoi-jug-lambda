package org.exoplatform.bch.predicate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by bdechateauvieux on 4/5/15.
 */
public class ActivityFilter {


    static final List<Activity> activities = new ArrayList<>();

    static {
        activities.add(new Activity("1st activity", 4, 10, new Date()));
        activities.add(new Activity("2nd activity", 0, 0, new Date()));
        activities.add(new Activity("3rd activity", 1, 76, new Date()));
        activities.add(new Activity("4th activity", 0, 76, new Date()));
    }

    private Activity getFirstMatchingActivity(List<Activity> activities, Predicate<Activity> matcher) {
        for (Activity activity: activities) {
            if (matcher.test(activity)) {
                return activity;
            }
        }
        return null;
    }

    public static void main(String... args) {
        ActivityFilter filter = new ActivityFilter();
        Activity firstMatch;

        //First activity with more than 50 comments and no likes
        Predicate<Activity> moreThan50comments = a -> a.getNbComments() > 50;
        Predicate<Activity> noLikes            = a -> a.getNbLikes() == 0;
        firstMatch = filter.getFirstMatchingActivity(activities, moreThan50comments.and(noLikes));


        //First activity with more than 50 comments
//        firstMatch = filter.getFirstMatchingActivity(activities, moreThan50comments);
        System.out.println(firstMatch.getTitle());

        //First activity with no likes
        firstMatch = filter.getFirstMatchingActivity(activities, noLikes);
        System.out.println(firstMatch.getTitle());


        //First activity with more than 50 comments and no likes
        firstMatch = filter.getFirstMatchingActivity(activities, moreThan50comments.and(noLikes));
        System.out.println(firstMatch.getTitle());
    }
}
