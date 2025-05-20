package org.example.designpatterns.creational.abstractfactory.factory;

import org.example.designpatterns.creational.abstractfactory.Company;
import org.example.designpatterns.creational.abstractfactory.product.AsusGpu;
import org.example.designpatterns.creational.abstractfactory.product.AsusMonitor;
import org.example.designpatterns.creational.abstractfactory.product.Gpu;
import org.example.designpatterns.creational.abstractfactory.product.Monitor;

public class AsusManufacturer extends Company {

    @Override
    public Gpu createGpu() {
        return new AsusGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new AsusMonitor();
    }
}
