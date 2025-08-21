package org.example.designpatterns.structural.facade.thirdparty;

public abstract class CryptoService {

    private DatabaseService databaseService;
    private SomeComplexStuff complexStuff;

    public abstract void buyCurrency(User user, double amount);

    public static class SomeComplexStuff { }

}

