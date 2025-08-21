package org.example.designpatterns.creational.builder;

public class Main {

    public static void main(String[] args) {
        Car car = Car.builder()
                .id(1L)
                .brand("BMW")
                .model("M5")
                .build();
        System.out.println(car);
    }

}
