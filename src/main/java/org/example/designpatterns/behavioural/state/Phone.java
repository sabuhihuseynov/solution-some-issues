package org.example.designpatterns.behavioural.state;

public class Phone {

    private State state;

    public Phone() {

    }

    public void setState(State state) {
        this.state = state;
    }

    public String lock() {
        return "Locking phone and turning off the screen";
    }

    public String home() {
        return "Going to home screen";
    }

    public String unlock() {
        return "Unlocking phone to home";
    }

    public String turnOn() {
        return "Turning on screen, screen still locked";
    }

}
