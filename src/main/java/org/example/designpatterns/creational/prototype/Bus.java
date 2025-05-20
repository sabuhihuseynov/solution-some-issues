package org.example.designpatterns.creational.prototype;

public class Bus extends Vehicle {

    private int numberOfDoors;

    public Bus(Bus bus) {
        super(bus);
        this.numberOfDoors = bus.numberOfDoors;
    }

    @Override
    public Bus clone() {
        return new Bus(this);
    }
}
