package org.example;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

public class TaskManager {
    @TaskInfo(priority = "HIGH", assignedTo = "RAM")
    void completeTask() {
    }

    public static void main(String[] args) throws Exception {
        Method m = TaskManager.class.getDeclaredMethod("completeTask");
        TaskInfo t = m.getAnnotation(TaskInfo.class);
        System.out.println(t.priority() + " " + t.assignedTo());
    }
}
