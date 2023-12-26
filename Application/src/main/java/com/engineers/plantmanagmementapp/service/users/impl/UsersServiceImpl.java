package com.engineers.plantmanagmementapp.service.users.impl;

import com.engineers.plantmanagmementapp.errors.users.RoleNotExistsException;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.repository.RoleRepository;
import com.engineers.plantmanagmementapp.repository.UserRepository;
import com.engineers.plantmanagmementapp.service.users.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UserRepository usersRepo;
    private final RoleRepository roleRepo;

    @Override
    public Long setUserRole(final Long userId, final String role) {
        final var foundRole = roleRepo.findByName(role);
        if (!foundRole.isEmpty()) {
            final var user = usersRepo.findById(userId).orElseThrow();
            user.setRole(foundRole.get());
            return usersRepo.save(user).getId();
        }
        throw new RoleNotExistsException("Role " + role + " not exists");
    }

    @Override
    public List<User> searchByEmail(final String searchPhrase) {
        return usersRepo.findAllByEmailContainingIgnoreCase(searchPhrase);
    }
}
