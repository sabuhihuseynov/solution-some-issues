package org.example.designpatterns.structural.bridge;

public class PepperoniPizza extends Pizza {

    @Override
    protected void assemble() {
        System.out.println("Adding sauce: " + sauce);
        System.out.println("Adding toppings: " + toppings);
        System.out.println("Adding pepperoni");
    }

    @Override
    protected void qualityCheck() {
        System.out.println("Crust is: " + crust);
    }
}
