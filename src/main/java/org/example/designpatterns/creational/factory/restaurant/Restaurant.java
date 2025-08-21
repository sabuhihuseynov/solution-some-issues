package org.example.designpatterns.creational.factory.restaurant;

import org.example.designpatterns.creational.factory.product.Burger;

public abstract class Restaurant {

    public Burger orderBurger() {
        Burger burger = createBurger();
        burger.prepare();
        return burger;
    }

    public abstract Burger createBurger();

}
