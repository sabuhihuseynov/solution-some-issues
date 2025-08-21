package org.example.designpatterns.behavioural.chainofresponsibility;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private final Map<String, String> users;

    public Database() {
        users = new HashMap<>();
        users.put("harry", "expelliarmus");
        users.put("hermione", "wingardium&leviosa");
        users.put("ron", "alohomora");
    }

    public boolean isValidUser(String username) {
        return users.containsKey(username);
    }

    public boolean isValidPassword(String username, String password) {
        return users.get(username).equals(password);
    }

}
