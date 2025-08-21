package org.example.designpatterns.behavioural.strategy;

public class PaymentService {

    public int cost;
    public boolean includeDelivery;
    private PaymentStrategy strategy;

    public void processOrder() {
        strategy.pay(getTotal());
    }

    private int getTotal() {
        return includeDelivery ? cost + 10 : cost;
    }
}
