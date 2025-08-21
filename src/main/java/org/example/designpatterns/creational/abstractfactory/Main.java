package org.example.designpatterns.creational.abstractfactory;

import org.example.designpatterns.creational.abstractfactory.factory.AsusManufacturer;
import org.example.designpatterns.creational.abstractfactory.factory.MsiManufacturer;
import org.example.designpatterns.creational.abstractfactory.product.Gpu;
import org.example.designpatterns.creational.abstractfactory.product.Monitor;

public class Main {

    public static void main(String[] args) {
        Company msi = new MsiManufacturer();
        Gpu msiGpu = msi.createGpu();
        Monitor msiMonitor = msi.createMonitor();

        Company asus = new AsusManufacturer();
        Gpu asusGpu = asus.createGpu();
        Monitor asusMonitor = asus.createMonitor();
    }


}
