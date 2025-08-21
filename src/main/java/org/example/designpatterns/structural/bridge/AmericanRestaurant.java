package org.example.designpatterns.structural.bridge;

public class AmericanRestaurant extends Restaurant {

    public AmericanRestaurant(Pizza pizza) {
        super(pizza);
    }

    @Override
    void addSauce() {
        pizza.setSauce("Super secret recipe");
    }

    @Override
    void addToppings() {
        pizza.setToppings("Everything");
    }

    @Override
    void makeCrust() {
        pizza.setCrust("Thick");
    }
}
