package org.example.designpatterns.behavioural.strategy;

public class PaymentByPayPal implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paying" + amount + " using PayPal");
    }
}
