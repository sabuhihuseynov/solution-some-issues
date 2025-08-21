package org.example.designpatterns.behavioural.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationService {

    private final Map<Event, List<EventListener>> customers;

    public NotificationService() {
        this.customers = new HashMap<>();
        Arrays.stream(Event.values()).forEach(event -> this.customers.put(event, new ArrayList<>()));
    }

    public void subscribe(Event event, EventListener listener) {
        customers.get(event).add(listener);
    }

    public void unsubscribe(Event event, EventListener listener) {
        customers.get(event).remove(listener);
    }

    public void notify(Event event) {
        customers.get(event).forEach(e -> e.update(event));
    }
}
