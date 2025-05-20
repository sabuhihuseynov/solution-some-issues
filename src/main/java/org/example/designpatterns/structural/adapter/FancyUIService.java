package org.example.designpatterns.structural.adapter;

public class FancyUIService {

    public void displayMenus(String jsonData) {
        System.out.println("Displaying menus from JSON: " + jsonData);
    }

    public void displayRecommendations(String jsonData) {
        System.out.println("Displaying recommendations from JSON: " + jsonData);
    }
}
