package org.example;

import java.lang.reflect.*;

public class DynamicInvoker {
    public static void main(String[] args) throws Exception {
        MathOperations ops = new MathOperations();
        Method m = MathOperations.class.getMethod("add", int.class, int.class);
        System.out.println(m.invoke(ops, 10, 5));
    }
}

class MathOperations {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}
