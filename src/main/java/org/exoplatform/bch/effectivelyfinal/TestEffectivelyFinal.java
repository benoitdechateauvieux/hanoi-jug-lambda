package org.exoplatform.bch.effectivelyfinal;

import java.util.function.Consumer;

/**
 * Created by bdechateauvieux on 4/14/15.
 */
public class TestEffectivelyFinal {

    private void myMethod() {

        //Explicit final variable
        final int count1 = 0;
        doSomething( (emp) -> use(count1));

        //Variable is not declared final but never modified
        // => Effectively final
        int count2 = 0;
        doSomething( (emp) -> use(count2));

        //Variable is modified
        int count3 = 0;
        count3++;
//        doSomething( (emp) -> use(count3)); -- Compilation error




    }

    //Dummy
    private void use(int count) {
    }

    //Dummy
    private void doSomething(Consumer<Employee> emp) {
    }

    //Dummy
    private class Employee {}
}
