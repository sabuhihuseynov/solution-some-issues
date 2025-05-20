package org.example.designpatterns.behavioural.command;

public class Room {

    private Command command;

    public Room() {}

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }


}
