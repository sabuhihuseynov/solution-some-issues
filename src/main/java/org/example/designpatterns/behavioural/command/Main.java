package org.example.designpatterns.behavioural.command;

public class Main {

    public static void main(String[] args) {
        Room livingRoom = new LivingRoom();
        livingRoom.setCommand(new SwitchLightCommand(new Light()));
        livingRoom.executeCommand();
    }
}
