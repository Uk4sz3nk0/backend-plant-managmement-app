package com.engineers.plantmanagmementapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * HarvestStats - Entity class that represents harvest stats for every harvest day and for every assigned to it person
 * Created on: 2023-12-06
 *
 * @author Łukasz Wodniak
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users_stats")
public class UserStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long collectedContainers;
    @ManyToOne
    @JoinColumn(name = "harvest_id")
    private Harvest harvest;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
