package org.exoplatform.bch.functionalinterface;

/**
 * Created by bdechateauvieux on 3/31/15.
 */
public class FuncInterfaceTest {

    public static double integrate(Integrable function, double x1, double x2, int numSlices) {
        if (numSlices<1) {
            numSlices = 1;
        }
        double delta = (x2-x1)/numSlices;
        double start = x1+delta/2;
        double sum = 0;
        for (int i=0; i<numSlices; i++) {
            sum += delta * function.eval(start + delta*i);
        }
        return sum;
    }

    public static void applyMathematicalFunction(Integrable function, double x1, double x2) {
        for (int i=1; i<7; i++) {
            int numSlices = (int) Math.pow(10,i);
            double result = FuncInterfaceTest.integrate(function, x1, x2, numSlices);
            System.out.printf(" For numslices =%,10d result = %,.8f%n", numSlices, result);
        }
    }

    public static void main(String... args) {

        // Both invocations are equivalent
        applyMathematicalFunction(x -> Math.sin(x), 10, 100);
        applyMathematicalFunction(Math::sin, 10, 100);

    }
}
