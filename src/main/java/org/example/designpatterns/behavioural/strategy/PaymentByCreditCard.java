package org.example.designpatterns.behavioural.strategy;

public class PaymentByCreditCard implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paying" + amount + " using credit card");
    }
}
