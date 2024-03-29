package com.engineers.plantmanagmementapp.mapper;

import com.engineers.plantmanagmementapp.model.Permission;
import com.engineers.plantmanagmementapp.record.AuthenticationRequest;
import com.engineers.plantmanagmementapp.record.AuthenticationResponse;
import com.engineers.plantmanagmementapp.record.RegisterRequest;
import com.engineers.plantmanagmementapp.rest.authentication.specification.model.AuthenticationRequestDto;
import com.engineers.plantmanagmementapp.rest.authentication.specification.model.AuthenticationResponseDto;
import com.engineers.plantmanagmementapp.rest.authentication.specification.model.RegisterRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class AuthenticationMapper {

    public static final AuthenticationMapper INSTANCE = Mappers.getMapper(AuthenticationMapper.class);

    public abstract RegisterRequest map(final RegisterRequestDto request);

    public abstract AuthenticationRequest map(final AuthenticationRequestDto request);

    @Mapping(source = "accessTokenDuration", target = "accessTokenDuration")
    @Mapping(source = "refreshTokenDuration", target = "refreshTokenDuration")
    public abstract AuthenticationResponseDto map(final AuthenticationResponse response);

    public String map(final Permission permission) {
        return permission.getName();
    }
}
