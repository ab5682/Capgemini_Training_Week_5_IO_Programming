package org.example;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

class Engine {
    public void start() {
        System.out.println("Engine started.");
    }
}

class Car {
    @Inject
    Engine engine;

    public void run() {
        engine.start();
    }
}

public class DIContainer {
    public static void inject(Object obj) throws Exception {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(obj, field.getType().getDeclaredConstructor().newInstance());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Car car = new Car();
        inject(car);
        car.run();
    }
}
