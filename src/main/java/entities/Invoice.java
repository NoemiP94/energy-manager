package entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "invoices")
@Getter
@Setter
@ToString
public class Invoice {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID uuid;
    private LocalDate date;
    private int number;
    private double amount;
    @Enumerated(EnumType.STRING)
    private InvoiceState invoiceState;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

}
