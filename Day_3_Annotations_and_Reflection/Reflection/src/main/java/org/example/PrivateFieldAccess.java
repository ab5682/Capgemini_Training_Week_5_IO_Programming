package org.example;



import java.lang.reflect.*;

public class PrivateFieldAccess {
    public static void main(String[] args) throws Exception {
        Man p = new Man();
        Field f = Man.class.getDeclaredField("age");
        f.setAccessible(true);
        f.set(p, 30);
        System.out.println(f.get(p));
    }
}

class Man {
    private int age = 20;
}
