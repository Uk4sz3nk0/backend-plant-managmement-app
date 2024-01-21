package com.engineers.plantmanagmementapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * User - Entity model class
 * Created on: 2023-10-18
 *
 * @author Łukasz Wodniak
 */

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToMany(mappedBy = "owner")
    private List<Plantation> ownedPlantations;
    @ManyToMany
    @JoinTable(
            name = "user_plantation",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "plantation_id"))
    private List<Plantation> plantations;
}
