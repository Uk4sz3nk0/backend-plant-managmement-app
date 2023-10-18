package com.engineers.plantmanagmementapp.model;

import com.engineers.plantmanagmementapp.enums.Role;
import jakarta.persistence.*;
import lombok.*;

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
@Table(name = "_users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
