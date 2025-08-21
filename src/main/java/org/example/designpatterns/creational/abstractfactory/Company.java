package org.example.designpatterns.creational.abstractfactory;

import org.example.designpatterns.creational.abstractfactory.product.Gpu;
import org.example.designpatterns.creational.abstractfactory.product.Monitor;

public abstract class Company {

    //business logic can be added here

    public abstract Gpu createGpu();

    public abstract Monitor createMonitor();

}
