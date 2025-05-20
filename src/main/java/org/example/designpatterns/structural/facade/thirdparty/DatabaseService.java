
package org.example.designpatterns.structural.facade.thirdparty;

public class DatabaseService {

    public User getUser(String userId) {
        return new User("A1", "Geekific", 1000, "USD", "123456LNS");
    }

}

