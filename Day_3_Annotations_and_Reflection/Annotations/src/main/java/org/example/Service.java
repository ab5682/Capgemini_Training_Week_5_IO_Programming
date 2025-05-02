package org.example;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class Service {
    @ImportantMethod
    void criticalTask() {}

    @ImportantMethod(level = "MEDIUM")
    void regularTask() {}

    public static void main(String[] args) {
        for (Method m : Service.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod imp = m.getAnnotation(ImportantMethod.class);
                System.out.println(m.getName() + " " + imp.level());
            }
        }
    }
}
