package com.engineers.plantmanagmementapp.model;

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
    @GeneratedValue
    private Long id;
    private String name;
    private String nip;
    private String regon;
    private String city;
    private String street;
    private Integer houseNumber;
    private Integer flatNumber;
    private String postCode;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    @ManyToMany(mappedBy = "plantations")
    private List<User> employees;
}
