package pl.yellowduck.netflix90.commands;

public interface Command {

    void handle();

    boolean isHandle(String readOption);
}
