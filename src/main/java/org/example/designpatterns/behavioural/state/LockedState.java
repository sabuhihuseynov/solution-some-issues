package org.example.designpatterns.behavioural.state;

public class LockedState extends State {

    public LockedState(Phone phone) {
        super(phone);
    }

    @Override
    protected String onHome() {
        phone.setState(new ReadyState(phone));
        return phone.unlock();
    }

    @Override
    protected String onOffOn() {
        phone.setState(new OffState(phone));
        return phone.lock();
    }
}
