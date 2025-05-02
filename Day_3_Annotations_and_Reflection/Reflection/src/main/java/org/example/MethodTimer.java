package org.example;

import java.lang.reflect.Method;

class Service {
    public void process() throws InterruptedException {
        Thread.sleep(300);
        System.out.println("Processing done.");
    }
}

public class MethodTimer {
    public static void main(String[] args) throws Exception {
        Service service = new Service();
        Method method = Service.class.getMethod("process");

        long start = System.nanoTime();
        method.invoke(service);
        long end = System.nanoTime();

        System.out.println("Execution time (ns): " + (end - start));
    }
}
