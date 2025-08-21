package org.example.designpatterns.behavioural.chainofresponsibility;

import org.example.designpatterns.behavioural.chainofresponsibility.handler.Handler;
import org.example.designpatterns.behavioural.chainofresponsibility.handler.RoleCheckHandler;
import org.example.designpatterns.behavioural.chainofresponsibility.handler.UserExistsHandler;
import org.example.designpatterns.behavioural.chainofresponsibility.handler.ValidPasswordHandler;

public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        Handler handler = new UserExistsHandler(database);
        handler.setNextHandler(new ValidPasswordHandler(database))
                .setNextHandler(new RoleCheckHandler());
        AuthService authService = new AuthService(handler);
        authService.logIn("harry", "expellawdawdiarmus");
    }
}
