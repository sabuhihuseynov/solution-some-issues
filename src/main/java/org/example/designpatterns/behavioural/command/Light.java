package org.example.designpatterns.behavioural.command;

public class Light {

    private boolean switchOn;

    public void switchLights() {
        switchOn = !switchOn;
    }

}
