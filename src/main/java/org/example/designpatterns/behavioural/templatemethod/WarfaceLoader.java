package org.example.designpatterns.behavioural.templatemethod;

public class WarfaceLoader extends BaseGameLoader {
    @Override
    byte[] loadLocalData() {
        return new byte[0];
    }

    @Override
    void createObjects(byte[] data) {
        System.out.println("WarfaceLoader create objects");
    }

    @Override
    void downloadAdditionalFiles() {
        System.out.println("WarfaceLoader download additional files");
    }

    @Override
    void initializeProfiles() {
        System.out.println("WarfaceLoader initialize profiles");
    }
}
