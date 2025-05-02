package org.example;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AccessControl {
    String currentUserRole = "USER";

    @RoleAllowed("ADMIN")
    void deleteData() {
        System.out.println("Data Deleted");
    }

    public static void main(String[] args) throws Exception {
        AccessControl ac = new AccessControl();
        for (Method m : AccessControl.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed role = m.getAnnotation(RoleAllowed.class);
                if (role.value().equals(ac.currentUserRole)) {
                    m.invoke(ac);
                } else {
                    System.out.println("Access Denied!");
                }
            }
        }
    }
}
