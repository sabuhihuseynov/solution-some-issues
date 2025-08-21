package org.example.designpatterns.behavioural.state;

public class OffState extends State {

    public OffState(Phone phone) {
        super(phone);
    }

    @Override
    protected String onHome() {
        phone.setState(new LockedState(phone));
        return phone.turnOn();
    }

    @Override
    protected String onOffOn() {
        phone.setState(new LockedState(phone));
        return phone.turnOn();
    }
}
