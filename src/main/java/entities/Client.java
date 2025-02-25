package entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients")
@Getter
@Setter
@ToString
public class Client {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID uuid;
    @Column(name = "business_name")
    private String businessName;
    @Column(name = "pIVA")
    private String VATNumber;
    private String email;
    @Column(name = "input_date")
    private LocalDate inputDate;
    @Column(name = "last_contact_date")
    private LocalDate lastContactDate;
    @Column(name = "annual_revenue")
    private long annualRevenue;
    private String pec;
    private String telephone;
    @Column(name = "telephone_number_contact")
    private String telephoneNumberContact;
    @Column(name = "contact_mail")
    private String contactMail;
    @Column(name = "contact_name")
    private String contactName;
    @Column(name = "contact_surname")
    private String contactSurname;
    String logo;
    @Enumerated(EnumType.STRING)
    private ClientType clientType;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address legalAddress;

    @OneToOne
    @JoinColumn(name = "operativeAddress_id")
    private Address operativeAddress;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Invoice> invoices;

}
