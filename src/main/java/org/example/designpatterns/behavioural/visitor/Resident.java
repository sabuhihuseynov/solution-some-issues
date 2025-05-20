package org.example.designpatterns.behavioural.visitor;

public class Resident extends Client {

    protected Resident(String name, String address, String number) {
        super(name, address, number);
    }

    @Override
    protected void accept(Visitor visitor) {
        visitor.visitResident(this);
    }
}
