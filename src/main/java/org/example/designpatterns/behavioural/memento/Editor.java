package org.example.designpatterns.behavioural.memento;

import java.util.Deque;
import java.util.LinkedList;

public class Editor {

    private final Deque<TextArea.Memento> stateHistory;
    private final TextArea textArea;

    public Editor() {
        stateHistory = new LinkedList<>();
        textArea = new TextArea();
    }

    public void write(String text) {
        textArea.setText(text);
        stateHistory.add(textArea.takeSnapshot());
    }

    public void undo() {
        textArea.restore(stateHistory.removeLast());
    }

    public String getText() {
        return textArea.getText();
    }

}
