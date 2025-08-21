
package org.example.designpatterns.structural.facade;

public class MainApp {

    public static void main(String[] args) {

        BuyCryptoFacade buyCrypto = new BuyCryptoFacade();
        buyCrypto.buyCryptocurrency(1000, "BTC");

    }

}
