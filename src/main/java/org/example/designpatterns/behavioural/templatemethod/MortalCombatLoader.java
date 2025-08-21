package org.example.designpatterns.behavioural.templatemethod;

public class MortalCombatLoader extends BaseGameLoader {

    @Override
    byte[] loadLocalData() {
        return new byte[0];
    }

    @Override
    void createObjects(byte[] data) {
        System.out.println("Mortal Combat Loader creates objects");
    }

    @Override
    void downloadAdditionalFiles() {
        System.out.println("Mortal Combat Loader download additional files");
    }

    @Override
    void initializeProfiles() {
        System.out.println("Mortal Combat Loader initializing profiles");
    }
}
