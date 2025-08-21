package org.example.designpatterns.structural.facade.thirdparty;

public class CryptoFactory {

    public static CryptoService getCryptoService(String currency) {
        if (currency.equals("BTC")) {
            return new BitcoinService();
        } else if (currency.equals("ETH")) {
            return new EthereumService();
        } else {
            // More Stuff
            return new BitcoinService();
        }
    }

}