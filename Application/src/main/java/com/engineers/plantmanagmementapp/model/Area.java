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
@Table(name = "areas")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String polygonColor;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "area_coordinates",
            joinColumns = @JoinColumn(name = "area_id"),
            inverseJoinColumns = @JoinColumn(name = "coordinate_id")
    )
    List<Coordinate> coordinates;
    @ManyToMany
    @JoinTable(
            name = "plantation_area",
            joinColumns = @JoinColumn(name = "area_id"),
            inverseJoinColumns = @JoinColumn(name = "plantation_id")
    )
    private List<Plantation> plantations;
}
