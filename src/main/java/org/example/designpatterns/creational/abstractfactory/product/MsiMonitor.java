package org.example.designpatterns.creational.abstractfactory.product;

public class MsiMonitor implements Monitor {

    @Override
    public void assemble() {
        System.out.println("MsiMonitor assembled");
    }
}
