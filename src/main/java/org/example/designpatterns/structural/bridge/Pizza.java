package org.example.designpatterns.structural.bridge;

import lombok.Data;

@Data
public abstract class Pizza {

    protected String sauce;
    protected String toppings;
    protected String crust;

    protected abstract void assemble();
    protected abstract void qualityCheck();
}
