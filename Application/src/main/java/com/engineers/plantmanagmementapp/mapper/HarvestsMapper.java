package com.engineers.plantmanagmementapp.mapper;

import com.engineers.plantmanagmementapp.model.Harvest;
import com.engineers.plantmanagmementapp.model.UserHarvest;
import com.engineers.plantmanagmementapp.record.Pagination;
import com.engineers.plantmanagmementapp.rest.harvests.specification.model.HarvestDto;
import com.engineers.plantmanagmementapp.rest.harvests.specification.model.PagedHarvestDto;
import com.engineers.plantmanagmementapp.rest.harvests.specification.model.PaginationRequestDto;
import com.engineers.plantmanagmementapp.rest.harvests.specification.model.UserHarvestDto;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

/**
 * HarvestsMapper - Mapper abstract class to map objects in Harvest and UserHarvest operations
 * Created on: 2023-11-25
 *
 * @author Łukasz Wodniak
 */

@RequiredArgsConstructor
@Mapper
public abstract class HarvestsMapper {

    public static HarvestsMapper INSTANCE = Mappers.getMapper(HarvestsMapper.class);

    public abstract Pagination map(final PaginationRequestDto paginationRequest);

    @Mapping(target = "sector", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "harvest", ignore = true)
    @Mapping(target = "plantation", ignore = true)
    public abstract UserHarvest map(final UserHarvestDto userHarvest);

    public abstract HarvestDto map(final Harvest harvest);

    public abstract PagedHarvestDto map(final Page<Harvest> page);
}
