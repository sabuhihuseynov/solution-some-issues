package org.example.designpatterns.behavioural.command;

public class SwitchLightCommand implements Command {

    private Light light;

    public SwitchLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchLights();
    }
}
