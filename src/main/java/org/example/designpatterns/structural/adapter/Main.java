package org.example.designpatterns.structural.adapter;

public class Main {

    public static void main(String[] args) {
        FancyUIServiceAdapter adapter = new FancyUIServiceAdapter();
        adapter.displayMenus("XML data");
        adapter.displayRecommendations("XML data");
    }
}
