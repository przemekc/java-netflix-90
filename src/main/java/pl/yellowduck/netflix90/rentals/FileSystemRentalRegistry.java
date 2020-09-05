package pl.yellowduck.netflix90.rentals;

import java.util.LinkedList;
import java.util.List;

public class FileSystemRentalRegistry implements RentalRegisty {

    private List<Rental> rentals = new LinkedList<>();

    @Override
    public void register(Rental rental) {
        rentals.add(rental);
    }

    @Override
    public List<Rental> getRentals() {
        return rentals;
    }
}
