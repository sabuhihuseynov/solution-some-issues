package org.example.designpatterns.creational.factory.restaurant;

import org.example.designpatterns.creational.factory.product.BeefBurger;
import org.example.designpatterns.creational.factory.product.Burger;

public class BeefBurgerRestaurant extends Restaurant {

    @Override
    public Burger createBurger() {
        return new BeefBurger();
    }
}
