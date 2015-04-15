package org.exoplatform.bch.basics;

/**
 * Created by bdechateauvieux on 4/14/15.
 */
public class MyRunnable {

    public static void main(String... args) {

        // Without Lambda (Anonymous Class)
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        };

        // Lambda
        Runnable r2 = () -> System.out.println("Hello world with Lambda !");

        // Run em!
        r1.run();
        r2.run();
    }
}
