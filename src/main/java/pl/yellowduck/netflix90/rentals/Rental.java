package pl.yellowduck.netflix90.rentals;

import lombok.Getter;
import lombok.Setter;
import pl.yellowduck.netflix90.clients.Client;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
//@RequiredArgsConstructor
public class Rental {


    private final String casseteId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identity;
    @ManyToOne
    private Client client;
    private final String cassetteId;
    private final LocalDate rentDate;
    private final int rentDays;
    private final BigDecimal rentCost;
    @Setter
    private LocalDate returnDate;

    private Rental(RentalBuilder builder) {

        this.client = builder.client;
        this.casseteId = builder.casseteId;
        this.cassetteId = builder.casseteId;
        this.rentDate = builder.rentDate;
        this.rentDays = builder.rentDays;
        this.rentCost = builder.rentCost;
    }

    public static RentalBuilder builder() {
        return new RentalBuilder();
    }

    public static final class RentalBuilder {
        private Client client;
        private String casseteId;
        private LocalDate rentDate;
        private int rentDays;
        private BigDecimal rentCost;
        private LocalDate returnDate;

        RentalBuilder() {
        }

//        public RentalBuilder withIdentity(int identity) {
//            this.identity = identity;
//            return this;
//        }

        public RentalBuilder withClientId(Client client) {
            this.client = client;
            return this;
        }

        public RentalBuilder withCasseteId(String casseteId) {
            this.casseteId = casseteId;
            return this;
        }

        public RentalBuilder withRentDate(LocalDate rentDate) {
            this.rentDate = rentDate;
            return this;
        }

        public RentalBuilder withRentDays(int rentDays) {
            this.rentDays = rentDays;
            return this;
        }

        public RentalBuilder withRentCost(BigDecimal rentCost) {
            this.rentCost = rentCost;
            return this;
        }

        public RentalBuilder withReturnDate(LocalDate returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public Rental build() {
            return new Rental(this);
        }
    }
}
