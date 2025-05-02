package org.example;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class DevBoard {
    @Todo(task = "Login page", assignedTo = "Ram")
    void login() {}

    @Todo(task = "Dashboard", assignedTo = "Shyam", priority = "HIGH")
    void dashboard() {}

    public static void main(String[] args) {
        for (Method m : DevBoard.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo t = m.getAnnotation(Todo.class);
                System.out.println(m.getName() + ": " + t.task() + ", " + t.assignedTo() + ", " + t.priority());
            }
        }
    }
}
