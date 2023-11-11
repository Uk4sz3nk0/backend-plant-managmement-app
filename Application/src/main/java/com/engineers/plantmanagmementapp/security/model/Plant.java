package com.engineers.plantmanagmementapp.security.model;

import com.engineers.plantmanagmementapp.enums.PlantType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Plant - Entity class that represents available plants in plantation
 * Created on: 2023-11-11
 *
 * @author Łukasz Wodniak
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "plants")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private PlantType type;
    @OneToMany(mappedBy = "plant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Variety> varieties = new ArrayList<>();
}
