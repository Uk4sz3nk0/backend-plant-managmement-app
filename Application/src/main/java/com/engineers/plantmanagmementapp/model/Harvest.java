package com.engineers.plantmanagmementapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * Harvest - Entity class that represents harvests as single day
 * Created on: 2023-11-22
 * @author Łukasz Wodniak
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "harvests")
public class Harvest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer season;
    private LocalDate date;
    @OneToMany(mappedBy = "harvest", cascade = CascadeType.ALL)
    private List<UserHarvest> userHarvests;
}
