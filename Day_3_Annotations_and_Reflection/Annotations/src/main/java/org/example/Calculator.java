package org.example;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class Calculator {
    @LogExecutionTime
    public void compute(int n) {
        long sum = 0;
        for (int i = 0; i < n; i++) sum += i;
        System.out.println("Sum: " + sum);
    }

    public static void main(String[] args) throws Exception {
        Method m = Calculator.class.getMethod("compute", int.class);
        if (m.isAnnotationPresent(LogExecutionTime.class)) {
            long start = System.nanoTime();
            m.invoke(new Calculator(), 1000000);
            long end = System.nanoTime();
            System.out.println("Execution time: " + (end - start) + " ns");
        }
    }
}
