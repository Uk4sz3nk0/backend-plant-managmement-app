package com.engineers.plantmanagmementapp.model;

import com.engineers.plantmanagmementapp.enums.PlantName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * UserHarvest - Entity class that represents detailed harvest info by user in specific day
 * Created on: 2023-11-22
 *
 * @author Łukasz Wodniak
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_harvests")
public class UserHarvest {

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private PlantName plantName;
    private Integer row;
    private LocalDateTime harvestStart;
    private LocalDateTime harvestEnd;
    @ManyToOne
    @JoinColumn(name = "harvest_id")
    private Harvest harvest;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "sector_id")
    private Area sector;
}
