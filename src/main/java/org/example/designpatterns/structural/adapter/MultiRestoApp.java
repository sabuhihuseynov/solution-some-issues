package org.example.designpatterns.structural.adapter;

public class MultiRestoApp implements IMultiRestoApp {

    @Override
    public void displayMenus(String xmlData) {
        System.out.println("Displaying Menus from XML");
    }

    @Override
    public void displayRecommendations(String xmlData) {
        System.out.println("Displaying Recommendations from XML");
    }
}
