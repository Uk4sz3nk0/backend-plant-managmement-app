package com.engineers.plantmanagmementapp.record;

import com.engineers.plantmanagmementapp.model.User;

public record AuthenticationResponse(User user, String accessToken, String refreshToken) {
}
