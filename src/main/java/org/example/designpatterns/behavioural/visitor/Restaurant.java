package org.example.designpatterns.behavioural.visitor;

public class Restaurant extends Client {

    protected Restaurant(String name, String address, String number) {
        super(name, address, number);
    }

    @Override
    protected void accept(Visitor visitor) {
        visitor.visitRestaurant(this);
    }
}
