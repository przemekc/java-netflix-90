package pl.yellowduck.netflix90.rentals;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import pl.yellowduck.netflix90.clients.Client;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RentalRegistryTest {

    @Test
    public void shouldRegisterRental() {
        // given
        Rental rental = Rental.builder()
               // .withIdentity(1)
               // .withClient(new Client client)
                .withCasseteId("001")
                .withRentDate(LocalDate.now())
                .withRentDays(5)
                .withRentCost(BigDecimal.valueOf(0))
                .build();

        RentalRegisty rentalRegisty = new FileSystemRentalRegistry();

        // when
        rentalRegisty.register(rental);

        // then
        List<Rental> rentalList = rentalRegisty.getRentals();
        assertThat(rentalList).contains(rental);
    }
}