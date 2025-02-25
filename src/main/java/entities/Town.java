package entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "towns")
@Getter
@Setter
@ToString
public class Town {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID uuid;
    @Column(name = "municipal_serial_num")
    private String municipalSerialNumber;
    private String name;
    @Column(name = "province_code")
    private String provinceCode;
    //list addresses
    //Province province
    @ManyToOne
    @JoinColumn(name = "province_name")
    private Province province;
}
