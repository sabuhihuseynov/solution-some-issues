package org.example.designpatterns.creational.abstractfactory.product;

public class AsusGpu implements Gpu {

    @Override
    public void assemble() {
        System.out.println("AsusGpu assembled");
    }
}
