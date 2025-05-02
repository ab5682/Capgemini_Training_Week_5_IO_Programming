package org.example;

import java.lang.reflect.*;

public class StaticFieldAccess {
    public static void main(String[] args) throws Exception {
        Field f = Configuration.class.getDeclaredField("API_KEY");
        f.setAccessible(true);
        f.set(null, "NEW_KEY_123");
        System.out.println(f.get(null));
    }
}

class Configuration {
    private static String API_KEY = "OLD_KEY";
}
