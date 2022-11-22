package com.designpattern.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class History {

    Deque<UndoableCommand> textCommands = new ArrayDeque<>();

    public void push(UndoableCommand command) {
        textCommands.push(command);
    }

    public UndoableCommand pop() {
        return textCommands.pop();
    }

}
