package org.example.designpatterns.behavioural.visitor;

import lombok.Getter;

@Getter
public abstract class Client {

    private final String name;
    private final String address;
    private final String number;

    protected Client(String name, String address, String number) {
        this.name = name;
        this.address = address;
        this.number = number;
    }

    protected abstract void accept(Visitor visitor);
}
