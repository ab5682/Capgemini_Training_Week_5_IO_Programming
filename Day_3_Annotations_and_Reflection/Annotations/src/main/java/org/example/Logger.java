package org.example;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogTime {}

class Logger {
    @LogTime
    void task1() {
        for (int i = 0; i < 1000000; i++);
    }

    @LogTime
    void task2() {
        for (int i = 0; i < 2000000; i++);
    }

    public static void main(String[] args) throws Exception {
        Logger l = new Logger();
        for (Method m : Logger.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(LogTime.class)) {
                long start = System.nanoTime();
                m.invoke(l);
                long end = System.nanoTime();
                System.out.println(m.getName() + ": " + (end - start) + " ns");
            }
        }
    }
}
