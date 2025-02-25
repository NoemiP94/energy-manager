package entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "provinces")
@Getter
@Setter
@ToString
public class Province {
    @Id
    @Column(name = "province_name")
    private String name;
    @Column(name = "province_code")
    private String provinceCode;
    private String region;
    //list towns
    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<Town> towns;
}
