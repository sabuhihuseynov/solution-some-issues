package org.example.designpatterns.behavioural.memento;

public class Main {

    public static void main(String[] args) {
        Editor editor = new Editor();

        editor.write("Life");
        System.out.println(editor.getText());
        editor.write("is what you think");
        System.out.println(editor.getText());
        editor.write("it is");
        System.out.println(editor.getText());
        editor.undo();
        System.out.println(editor.getText());
    }
}
