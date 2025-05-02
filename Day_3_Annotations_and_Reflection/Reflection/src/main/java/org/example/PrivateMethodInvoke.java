package org.example;

import java.lang.reflect.*;

public class PrivateMethodInvoke {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Method m = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        m.setAccessible(true);
        System.out.println(m.invoke(calc, 4, 5));
    }
}

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}
