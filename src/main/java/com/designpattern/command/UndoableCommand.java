package com.designpattern.command;

public interface UndoableCommand extends Command{

    void unExecute();
}
