package org.example;

import java.util.ArrayList;

public class WarningSuppressor {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Hello");
        System.out.println(list.getFirst());
    }
}
