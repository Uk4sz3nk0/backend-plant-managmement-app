package com.engineers.plantmanagmementapp.model;

import com.engineers.plantmanagmementapp.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

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
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
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
