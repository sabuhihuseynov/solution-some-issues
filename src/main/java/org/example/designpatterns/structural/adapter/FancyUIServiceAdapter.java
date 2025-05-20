package org.example.designpatterns.structural.adapter;

public class FancyUIServiceAdapter implements IMultiRestoApp {

    private final FancyUIService fancyUIService;

    public FancyUIServiceAdapter() {
        fancyUIService = new FancyUIService();
    }

    @Override
    public void displayMenus(String xmlData) {
        String jsonData = convertXmlToJson(xmlData);
        fancyUIService.displayMenus(jsonData);
    }

    @Override
    public void displayRecommendations(String xmlData) {
        String jsonData = convertXmlToJson(xmlData);
        fancyUIService.displayRecommendations(jsonData);
    }

    private String convertXmlToJson(String xmlData) {
        //Convert xml data to json and return it
        return "JSON data";
    }
}
