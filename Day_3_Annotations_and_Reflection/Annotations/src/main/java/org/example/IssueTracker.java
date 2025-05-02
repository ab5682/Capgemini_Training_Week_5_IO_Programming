package org.example;

import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

public class IssueTracker {
    @BugReport(description = "NullPointerException on line 23")
    @BugReport(description = "ArrayIndexOutOfBoundsException on line 45")
    void process() {
    }

    public static void main(String[] args) throws Exception {
        Method m = IssueTracker.class.getDeclaredMethod("process");
        BugReport[] bugs = m.getAnnotationsByType(BugReport.class);
        for (BugReport bug : bugs) {
            System.out.println(bug.description());
        }
    }
}
