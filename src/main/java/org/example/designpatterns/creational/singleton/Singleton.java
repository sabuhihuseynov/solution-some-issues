package org.example.designpatterns.creational.singleton;

public class Singleton {

    private String data;

    private Singleton(String data) {
        this.data = data;
    }

    private static final class InstanceHolder {
        private static final Singleton instance = new Singleton("Hello World");
    }

    public static Singleton getInstance() {
        return InstanceHolder.instance;
    }

}
