package org.example.designpatterns.creational.abstractfactory.factory;

import org.example.designpatterns.creational.abstractfactory.Company;
import org.example.designpatterns.creational.abstractfactory.product.Gpu;
import org.example.designpatterns.creational.abstractfactory.product.Monitor;
import org.example.designpatterns.creational.abstractfactory.product.MsiGpu;
import org.example.designpatterns.creational.abstractfactory.product.MsiMonitor;

public class MsiManufacturer extends Company {

    @Override
    public Gpu createGpu() {
        return new MsiGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new MsiMonitor();
    }
}
