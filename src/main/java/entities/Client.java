package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Client {
    @Id
    @GeneratedValue
    private UUID uuid;
    private String businessName;
    private String VATNumber;
    private String email;
    private LocalDate inputDate;
    private LocalDate lastContactDate;
    private long annualRevenue;
    private String pec;
    private String telephone;
    private String telephoneNumberContact;
    private String contactMail;
    private String contactName;
    private String contactSurname;
    String logo;
    private ClientType clientType;
    //legalAddress
    //operativeAddress
    //invoices

}
