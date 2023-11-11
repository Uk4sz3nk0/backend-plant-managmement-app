package com.engineers.plantmanagmementapp.security.model;

import com.engineers.plantmanagmementapp.enums.ContainerUnit;
import com.engineers.plantmanagmementapp.model.Plantation;
import com.engineers.plantmanagmementapp.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Container - Entity class that represents container for fruits or vegetables
 * Created on: 2023-11-11
 *
 * @author Łukasz Wodniak
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "containers")
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long currentCapacity;
    private Long maxCapacity;
    @Enumerated(EnumType.STRING)
    private ContainerUnit currentUnit;
    private Boolean predefined;
    @ManyToOne
    @JoinColumn(name = "plantation_id")
    private Plantation plantation;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    @OneToOne
    @JoinColumn(name = "plant_id")
    private Plant currentPlant;

}
