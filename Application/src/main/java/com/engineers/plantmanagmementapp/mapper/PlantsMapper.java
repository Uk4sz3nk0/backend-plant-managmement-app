package com.engineers.plantmanagmementapp.mapper;

import com.engineers.plantmanagmementapp.model.Plant;
import com.engineers.plantmanagmementapp.model.PlantVariety;
import com.engineers.plantmanagmementapp.record.Pagination;
import com.engineers.plantmanagmementapp.rest.plants.specification.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * PlantsMapper - Mapper class for Plant and PlantVariety objects
 * Created on: 2023-12-17
 *
 * @author Łukasz Wodniak
 */

@Mapper
public abstract class PlantsMapper {

    public static PlantsMapper INSTANCE = Mappers.getMapper(PlantsMapper.class);

    public abstract Plant map(final PlantDto plantDto);

    public abstract PlantVariety map(final PlantVarietyDto plantVarietyDto);

    public abstract PlantDto map(final Plant plant);

    public abstract PlantVarietyDto map(final PlantVariety plantVariety);

    public abstract List<PlantDto> map(final List<Plant> plants);

    public abstract List<PlantVarietyDto> mapVarieties(final List<PlantVariety> plantVarieties);

    public abstract Pagination map(final PageRequestDto pageRequestDto);

    public PagedPlantsDto map(final Page<Plant> plantPage) {
        final PagedPlantsDto paged = new PagedPlantsDto();
        final PageDto pageDto = new PageDto();
        pageDto.setPage(plantPage.getNumber());
        pageDto.setSize(plantPage.getSize());
        pageDto.setTotalElements((int) plantPage.getTotalElements());
        pageDto.setTotalPages(plantPage.getTotalPages());
        paged.setPage(pageDto);
        paged.setData(map(plantPage.getContent()));
        return paged;
    }

    public PagedPlantVarietiesDto mapVarieties(final Page<PlantVariety> plantVarieties) {
        final PagedPlantVarietiesDto paged = new PagedPlantVarietiesDto();
        final PageDto pageDto = new PageDto();
        pageDto.setPage(plantVarieties.getNumber());
        pageDto.setSize(plantVarieties.getSize());
        pageDto.setTotalElements((int) plantVarieties.getTotalElements());
        pageDto.setTotalPages(plantVarieties.getTotalPages());
        paged.setPage(pageDto);
        paged.setData(mapVarieties(plantVarieties.getContent()));
        return paged;
    }

}
