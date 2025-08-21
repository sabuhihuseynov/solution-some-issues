package org.example.designpatterns.behavioural.chainofresponsibility.handler;

public class RoleCheckHandler extends Handler {

    @Override
    public boolean handle(String username, String password) {
        if ("admin_username".equals(username)) {
            System.out.println("Loading Admin page");
            return true;
        }
        System.out.println("Loading Default page");
        return handleNext(username, password);
    }
}
