package pl.yellowduck.netflix90.rentals;

import lombok.Getter;
import lombok.Setter;
import pl.yellowduck.netflix90.clients.Client;
import pl.yellowduck.netflix90.films.Actor;
import pl.yellowduck.netflix90.films.VideoCassette;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_client") // w bazie id_client
    private Client client;
    // client_id

    @ManyToOne
    private VideoCassette cassete;
    // cassete_id

    @Column(name = "rent_date")
    private LocalDate rentDate;
    private int rentDays;
    private BigDecimal rentCost;

    @Setter
    private LocalDate returnDate;

    public Rental() {
    }

    private Rental(RentalBuilder builder) {
        this.client = builder.client;
        this.cassete = builder.cassete;
        this.rentDate = builder.rentDate;
        this.rentDays = builder.rentDays;
        this.rentCost = builder.rentCost;
    }

    public static RentalBuilder builder() {
        return new RentalBuilder();
    }

    public static final class RentalBuilder {
        private Client client;
        private VideoCassette cassete;
        private LocalDate rentDate;
        private int rentDays;
        private BigDecimal rentCost;
        private LocalDate returnDate;

        private RentalBuilder() {
        }

        public RentalBuilder withClient(Client client) {
            this.client = client;
            return this;
        }

        public RentalBuilder withCassete(VideoCassette casseteId) {
            this.cassete = casseteId;
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
