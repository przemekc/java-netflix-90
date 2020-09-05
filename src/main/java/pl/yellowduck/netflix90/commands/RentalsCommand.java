package pl.yellowduck.netflix90.commands;

public class RentalsCommand implements Command {

    @Override
    public boolean isHandle(String readOption) {
        return readOption.equalsIgnoreCase("3");
    }

    @Override
    public void handle() {
        System.out.println("Rentals");
    }
}