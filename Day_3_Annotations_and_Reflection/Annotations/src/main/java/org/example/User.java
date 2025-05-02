package org.example;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    String username;

    User(String username) throws Exception {
        this.username = username;
        for (var f : this.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(MaxLength.class)) {
                f.setAccessible(true);
                MaxLength max = f.getAnnotation(MaxLength.class);
                String val = (String) f.get(this);
                if (val.length() > max.value()) {
                    throw new IllegalArgumentException("Length exceeds " + max.value());
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new User("John123");
    }
}

