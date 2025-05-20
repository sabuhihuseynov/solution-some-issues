package org.example.designpatterns.behavioural.state;

public abstract class State {

    protected Phone phone;

    protected State(Phone phone) {
        this.phone = phone;
    }

    protected abstract String onHome();
    protected abstract String onOffOn();

}
