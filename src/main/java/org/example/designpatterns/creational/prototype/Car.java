package org.example.designpatterns.creational.prototype;

public class Car extends Vehicle {

    private int topSpeed;

    public Car(Car car) {
        super(car);
        this.topSpeed = car.topSpeed;
    }

    @Override
    public Car clone() {
        return new Car(this);
    }
}
