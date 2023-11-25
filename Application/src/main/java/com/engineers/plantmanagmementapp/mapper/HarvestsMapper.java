package com.engineers.plantmanagmementapp.mapper;

import com.engineers.plantmanagmementapp.model.UserHarvest;
import com.engineers.plantmanagmementapp.record.Pagination;
import com.engineers.plantmanagmementapp.rest.harvests.specification.model.PaginationRequestDto;
import com.engineers.plantmanagmementapp.rest.harvests.specification.model.UserHarvestDto;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

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
}
