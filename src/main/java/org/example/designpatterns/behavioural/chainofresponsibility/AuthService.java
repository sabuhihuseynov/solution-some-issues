package org.example.designpatterns.behavioural.chainofresponsibility;

import org.example.designpatterns.behavioural.chainofresponsibility.handler.Handler;

public class AuthService {

    private final Handler handler;

    public AuthService(Handler handler) {
        this.handler = handler;
    }

    public boolean logIn(String username, String password) {
        if (handler.handle(username, password)) {
            System.out.println("Authorization successful");
            return true;
        }
        return false;
    }
}
