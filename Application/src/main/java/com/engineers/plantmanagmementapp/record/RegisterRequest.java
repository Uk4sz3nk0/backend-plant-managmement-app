package com.engineers.plantmanagmementapp.record;

import com.engineers.plantmanagmementapp.enums.Role;
import lombok.Builder;

@Builder
public record RegisterRequest(String firstName, String lastName, String email, String password, Role role, PlantationRecord plantation) {
}
