package pl.yellowduck.netflix90.commands;

public class FilmsCommand implements Command {

    @Override
    public boolean isHandle(String readOption) {
        return readOption.equalsIgnoreCase("2");
    }

    @Override
    public void handle() {
        System.out.println("Films");
    }
}