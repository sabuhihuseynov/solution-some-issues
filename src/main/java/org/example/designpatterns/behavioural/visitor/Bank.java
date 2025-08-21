package org.example.designpatterns.behavioural.visitor;

public class Bank extends Client {

    protected Bank(String name, String address, String number) {
        super(name, address, number);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBank(this);
    }
}
