package org.example.designpatterns.structural.composite;

import lombok.Data;

@Data
public abstract class Product implements Box {

    protected final String title;
    protected final double price;

    protected Product(String title, double price) {
        this.title = title;
        this.price = price;
    }


}
