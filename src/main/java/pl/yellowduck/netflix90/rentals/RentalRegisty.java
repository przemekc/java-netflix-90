package pl.yellowduck.netflix90.rentals;

import java.util.List;

public interface RentalRegisty {

    void register(Rental rental);

    List<Rental> getRentals();
}
