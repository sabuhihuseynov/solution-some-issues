package org.example.designpatterns.behavioural.observer;

public class MobileAppListener implements EventListener {

    private final String username;

    public MobileAppListener(String username) {
        this.username = username;
    }

    @Override
    public void update(Event event) {
        //Send the push notification
    }
}
