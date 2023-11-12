package com.engineers.plantmanagmementapp.mapper;

import com.engineers.plantmanagmementapp.rest.containers.specification.model.ContainerDto;
import com.engineers.plantmanagmementapp.security.model.Container;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ContainersMapper - Mapper abstract class
 * Created on: 2023-11-12
 *
 * @author Łukasz Wodniak
 */

@Mapper
public abstract class ContainersMapper {

    public static ContainersMapper INSTANCE = Mappers.getMapper(ContainersMapper.class);

    @Mapping(target = "plantation", ignore = true)
    @Mapping(target = "owner", ignore = true)
    @Mapping(target = "currentPlant", ignore = true)
    public abstract Container map(final ContainerDto containerDto);

    @Mapping(target = "plantationId", source = "plantation.id")
    @Mapping(target = "ownerId", source = "owner.id")
    @Mapping(target = "plantId", source = "currentPlant.id")
    public abstract ContainerDto map(final Container container);

    public abstract List<ContainerDto> map(final List<Container> containers);
}
