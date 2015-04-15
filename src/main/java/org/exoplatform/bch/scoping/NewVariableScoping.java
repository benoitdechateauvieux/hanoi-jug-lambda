package org.exoplatform.bch.scoping;

/**
 * Created by bdechateauvieux on 4/15/15.
 */
public class NewVariableScoping {

    private ActivityDao activityDao;

    public static void main(String... args) {
        NewVariableScoping test = new NewVariableScoping();
        test.createAnActivityAsynchronously();
        test.createAnActivityAsynchronouslyWithLambda();
    }

    //With lambda
    private void createAnActivityAsynchronouslyWithLambda() {
//        Activity activity = activityDao.getMainActivity();

        Runnable myWorker = () -> {
            Activity activity = new Activity();
            activityDao.save(activity);
        };

        //Run background
        myWorker.run();
    }

    //Without lambda
    private void createAnActivityAsynchronously() {
        Activity activity = activityDao.getMainActivity();

        Runnable myWorker = new Runnable() {
            @Override
            public void run() {
                Activity activity = new Activity();
                activityDao.save(activity);
            }
        };

        //Run background
        myWorker.run();
    }


    int myGlobalCounter =0;

    //With lambda
    private void create500Activities() {
        int myLocalCounter =0;

        Runnable myWorker = () -> {
            for (int i=0; i<500; i++) {
                //I can read both counters
                System.out.println(myGlobalCounter);
                System.out.println(myLocalCounter);

                Activity activity = new Activity();
                activityDao.save(activity);

                //I can only update global counter
                myGlobalCounter++;
                //myLocalCounter++; -- Compilation error
            }
        };

        //Run background
        myWorker.run();
    }


    //Dummy DAO class
    private class ActivityDao {
        public void save(Activity activity) {
            //Nothing
        }

        public Activity getMainActivity() {
            return new Activity();
        }
    }
}
