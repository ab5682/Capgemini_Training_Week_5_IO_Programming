package org.example;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}

@Author(name = "Ram")
class Book {}

public class AnnotationReader {
    public static void main(String[] args) {
        Class<Book> cls = Book.class;
        if (cls.isAnnotationPresent(Author.class)) {
            Author a = cls.getAnnotation(Author.class);
            System.out.println("Author: " + a.name());
        }
    }
}
