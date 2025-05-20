package org.example.designpatterns.behavioural.chainofresponsibility.handler;

import org.example.designpatterns.behavioural.chainofresponsibility.Database;

public class UserExistsHandler extends Handler {

    private final Database database;

    public UserExistsHandler(final Database database) {
        this.database = database;
    }

    @Override
    public boolean handle(String username, String password) {
        if (!database.isValidUser(username)) {
            System.out.println("User " + username + " does not exist");
            return false;
        }
        return handleNext(username, password);
    }

}
