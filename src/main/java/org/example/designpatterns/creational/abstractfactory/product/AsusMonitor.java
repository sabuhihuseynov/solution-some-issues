package org.example.designpatterns.creational.abstractfactory.product;

public class AsusMonitor implements Monitor {

    @Override
    public void assemble() {
        System.out.println("AsusMonitor assembled");
    }
}
