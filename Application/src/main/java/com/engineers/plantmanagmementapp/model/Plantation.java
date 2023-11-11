package com.engineers.plantmanagmementapp.model;

import com.engineers.plantmanagmementapp.security.model.Container;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "plantations")
public class Plantation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nip;
    private String regon;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer flatNumber;
    private String postCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;
    @ManyToMany(mappedBy = "plantations")
    private List<User> employees;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "area_id")
    private Area area;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "plantation_sector",
            joinColumns = @JoinColumn(name = "plantation_id"),
            inverseJoinColumns = @JoinColumn(name = "sector_area_id")
    )
    private List<Area> sectors;
    @OneToMany(mappedBy = "plantation", cascade = CascadeType.ALL)
    private List<Container> containers;
}
