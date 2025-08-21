package org.example.designpatterns.behavioural.observer;

public class EmailMessageListener implements EventListener {

    private final String email;

    public EmailMessageListener(String email) {
        this.email = email;
    }

    @Override
    public void update(Event event) {
        // Send email
    }
}
