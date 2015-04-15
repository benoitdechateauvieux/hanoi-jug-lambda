package org.exoplatform.bch.predicate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by bdechateauvieux on 4/5/15.
 */
public class ActivitySimpleFilter {


    static final List<Activity> activities = new ArrayList<>();

    static {
        activities.add(new Activity("1st activity", 4, 10, new Date()));
        activities.add(new Activity("2nd activity", 0, 0, new Date()));
        activities.add(new Activity("3rd activity", 1, 76, new Date()));
        activities.add(new Activity("4th activity", 0, 76, new Date()));
    }
    public static void main(String... args) {
        ActivitySimpleFilter filter = new ActivitySimpleFilter();
        //filter.getActivities();
        filter.getActivitiesWithStream();
    }

    private Activity getFirstMatchingActivity(List<Activity> activities, Predicate<Activity> matcher) {
        for (Activity activity: activities) {
            if (matcher.test(activity)) {
                return activity;
            }
        }
        return null;
    }

    private void getActivities() {
        //First activity with no like
        getFirstMatchingActivity(activities, a -> a.getNbLikes() == 0);
        //First activity with more than 50 like
        getFirstMatchingActivity(activities, a -> a.getNbLikes() > 50);
    }

    private void getActivitiesWithStream() {
        System.out.println(activities.stream().filter(a -> a.getNbLikes() == 0).findFirst().get().getNbLikes());
    }
}
