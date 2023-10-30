package com.engineers.plantmanagmementapp.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Role - Enumerate class with existing roles
 * Created on: 2023-10-18
 *
 * @author Łukasz Wodniak
 */

@Getter
@RequiredArgsConstructor
public enum Role {

    USER(Collections.emptySet()),
    OWNER(Set.of(
            Permission.OWNER_READ,
            Permission.OWNER_CREATE,
            Permission.OWNER_UPDATE,
            Permission.OWNER_DELETE
    )),
    ADMIN(Set.of(
            Permission.ADMIN_READ,
            Permission.ADMIN_CREATE,
            Permission.ADMIN_UPDATE,
            Permission.ADMIN_DELETE
    ));

    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
