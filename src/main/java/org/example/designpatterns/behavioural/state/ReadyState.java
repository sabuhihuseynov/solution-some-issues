package org.example.designpatterns.behavioural.state;

public class ReadyState extends State {

    public ReadyState(Phone phone) {
        super(phone);
    }

    @Override
    protected String onHome() {
        return phone.home();
    }

    @Override
    protected String onOffOn() {
        phone.setState(new OffState(phone));
        return phone.lock();
    }
}
