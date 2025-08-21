package org.example.designpatterns.structural.bridge;

public class ItalianRestaurant extends Restaurant {

    public ItalianRestaurant(Pizza pizza) {
        super(pizza);
    }

    @Override
    void addSauce() {
        pizza.setSauce("Oil");
    }

    @Override
    void addToppings() {
        pizza.setToppings(null);
    }

    @Override
    void makeCrust() {
        pizza.setCrust("Thin");
    }
}
