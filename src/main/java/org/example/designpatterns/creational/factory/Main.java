package org.example.designpatterns.creational.factory;

import org.example.designpatterns.creational.factory.product.Burger;
import org.example.designpatterns.creational.factory.restaurant.BeefBurgerRestaurant;
import org.example.designpatterns.creational.factory.restaurant.Restaurant;
import org.example.designpatterns.creational.factory.restaurant.VeggieBurgerRestaurant;

public class Main {

    public static void main(String[] args) {
        Restaurant veggieRestaurant = new VeggieBurgerRestaurant();
        Burger veggieBurger = veggieRestaurant.orderBurger();

        Restaurant beefRestaurant = new BeefBurgerRestaurant();
        Burger beefBurger = beefRestaurant.orderBurger();


    }

}
