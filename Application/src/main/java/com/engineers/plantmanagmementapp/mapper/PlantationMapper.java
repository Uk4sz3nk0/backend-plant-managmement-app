package com.engineers.plantmanagmementapp.mapper;

import com.engineers.plantmanagmementapp.model.*;
import com.engineers.plantmanagmementapp.record.AreaRecord;
import com.engineers.plantmanagmementapp.record.CoordinateRecord;
import com.engineers.plantmanagmementapp.record.PlantationRecord;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.AreaDto;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.PlantationDto;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public abstract class PlantationMapper {

    public static PlantationMapper INSTANCE = Mappers.getMapper(PlantationMapper.class);

    @Mapping(target = "owner", ignore = true)
    @Mapping(target = "employee", ignore = true)
    public abstract PlantationRecord map(final PlantationDto plantationDto);

    public abstract AreaRecord map(final AreaDto areaDto);

    public abstract List<AreaDto> map(final List<Area> areas);

    public abstract List<PlantationDto> mapToDtoList(final List<Plantation> plantations);

    public abstract AreaDto map(final Area area);

    @Mapping(source = "owner.id", target = "ownerId")
    @Mapping(source = "employees", target = "employeeIds", qualifiedByName = "employeeToId")
    public abstract PlantationDto map(final Plantation plantation);

    public abstract List<Coordinate> mapCords(final List<CoordinateRecord> coordinateRecords);

    public abstract Coordinate map(final CoordinateRecord coordinateRecord);

    @Mapping(target = "plantations", ignore = true)
    public abstract Area map(final AreaRecord areaRecord);
    public abstract List<Area> mapAreas(final List<AreaRecord> areaRecords);

    public abstract List<UserDto> mapUsersToDto(final List<User> users);

    public abstract UserDto map(final User user);

    public String map(final Permission permission) {
        return permission.getName();
    }

    @Named("employeeToId")
    public List<Long> mapEmployeesToId(final List<User> users) {
        return users.stream().map(User::getId).collect(Collectors.toList());
    }

}
