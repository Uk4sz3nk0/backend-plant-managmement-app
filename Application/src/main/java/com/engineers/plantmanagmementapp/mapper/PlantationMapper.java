package com.engineers.plantmanagmementapp.mapper;

import com.engineers.plantmanagmementapp.model.Area;
import com.engineers.plantmanagmementapp.model.Plantation;
import com.engineers.plantmanagmementapp.record.AreaRecord;
import com.engineers.plantmanagmementapp.record.PlantationRecord;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.AreaDto;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.PlantationDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class PlantationMapper {

    public static PlantationMapper INSTANCE = Mappers.getMapper(PlantationMapper.class);

    public abstract PlantationRecord map(final PlantationDto plantationDto);

    public abstract AreaRecord map(final AreaDto areaDto);

    public abstract List<AreaDto> map(final List<Area> areas);
    public abstract List<PlantationDto> mapToDtoList(final List<Plantation> plantations);
    public abstract AreaDto map(final Area area);

    public abstract PlantationDto map(final Plantation plantation);

}
