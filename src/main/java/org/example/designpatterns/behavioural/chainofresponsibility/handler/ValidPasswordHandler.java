package org.example.designpatterns.behavioural.chainofresponsibility.handler;

import org.example.designpatterns.behavioural.chainofresponsibility.Database;

public class ValidPasswordHandler extends Handler {

    private final Database database;

    public ValidPasswordHandler(final Database database) {
        this.database = database;
    }


    @Override
    public boolean handle(String username, String password) {
        if (!database.isValidPassword(username, password)) {
            System.out.println("Invalid password");
            return false;
        }
        return handleNext(username, password);
    }
}
