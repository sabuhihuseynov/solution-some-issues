package org.example.designpatterns.creational.abstractfactory.product;

public class MsiGpu implements Gpu {

    @Override
    public void assemble() {
        System.out.println("MsiGpu assembled");
    }
}
