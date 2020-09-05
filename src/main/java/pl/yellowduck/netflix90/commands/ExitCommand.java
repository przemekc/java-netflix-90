package pl.yellowduck.netflix90.commands;

public class ExitCommand implements Command {

    @Override
    public boolean isHandle(String readOption) {
        return readOption.equalsIgnoreCase("q");
    }

    @Override
    public void handle() {
        System.exit(0);
    }
}
