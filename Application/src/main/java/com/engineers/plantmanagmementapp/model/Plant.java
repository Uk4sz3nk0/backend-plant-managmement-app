package com.engineers.plantmanagmementapp.model;

import com.engineers.plantmanagmementapp.enums.PlantType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Plant - Entity class that represents plant which is picked in plantation like vegetables or fruits.
 * Created on: 2023-12-13
 *
 * @author Łukasz Wodniak
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "plants")
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private PlantType type;
    @OneToMany(mappedBy = "plant")
    private List<PlantVariety> plantVarieties;

}
