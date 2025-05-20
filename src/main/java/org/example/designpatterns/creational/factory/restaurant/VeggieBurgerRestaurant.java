package org.example.designpatterns.creational.factory.restaurant;

import org.example.designpatterns.creational.factory.product.Burger;
import org.example.designpatterns.creational.factory.product.VeggieBurger;

public class VeggieBurgerRestaurant extends Restaurant {

    @Override
    public Burger createBurger() {
        return new VeggieBurger();
    }
}
