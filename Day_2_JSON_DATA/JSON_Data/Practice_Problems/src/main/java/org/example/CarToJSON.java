package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

class Car {
    public String model;
    public String brand;
    public int year;

    public Car(String model, String brand, int year) {
        this.model = model;
        this.brand = brand;
        this.year = year;
    }
}

public class CarToJSON {
    public static void main(String[] args) throws Exception {
        Car car = new Car("City", "Honda", 2022);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(car);
        System.out.println(json);
    }
}
