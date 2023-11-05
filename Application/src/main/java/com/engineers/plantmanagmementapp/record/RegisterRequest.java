package com.engineers.plantmanagmementapp.record;

import lombok.Builder;

@Builder
public record RegisterRequest(String firstName, String lastName, String email, String password, String role,
                              PlantationRecord plantation) {
}
