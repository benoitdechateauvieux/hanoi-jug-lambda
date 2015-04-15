package org.exoplatform.bch.scoping;

import java.util.function.Consumer;

/**
 * Created by bdechateauvieux on 4/6/15.
 */
public class TestScoping {

    private int instanceVariable = 900;



    private void testScoping(String monParam) {
        String maString = "maString";
        int localVariable = 0;
        Consumer<String> consumer = p -> {
            instanceVariable++;
//            localVariable++;
        };





        System.out.println(localVariable);
//            System.out.println(p);
//            System.out.println(localVariable);
//            System.out.println(monParam);
//            System.out.println(++instanceVariable);
//            String maStringLocale;
//            i++;
//        };
        consumer.accept(maString);
    }

    public static void main(String... args) {
        TestScoping instance = new TestScoping();
        instance.testScoping("monParam");
    }
}
