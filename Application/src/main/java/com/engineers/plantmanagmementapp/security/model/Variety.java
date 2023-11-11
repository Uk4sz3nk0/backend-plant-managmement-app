package com.engineers.plantmanagmementapp.security.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Variety - Entity class that represents available varieties of plants in app
 * Created on: 2023-11-11
 *
 * @author Łukasz Wodniak
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "varieties")
public class Variety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "plant_id", nullable = false)
    private Plant plant;
}
