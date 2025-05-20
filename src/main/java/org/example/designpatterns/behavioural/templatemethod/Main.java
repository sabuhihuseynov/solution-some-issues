package org.example.designpatterns.behavioural.templatemethod;

public class Main {
    public static void main(String[] args) {
        BaseGameLoader warfaceLoader = new WarfaceLoader();
        warfaceLoader.load();

        BaseGameLoader mortalCombatLoader = new MortalCombatLoader();
        mortalCombatLoader.load();
    }
}
