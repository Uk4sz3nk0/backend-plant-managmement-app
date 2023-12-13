package com.engineers.plantmanagmementapp.mapper;

import com.engineers.plantmanagmementapp.model.Harvest;
import com.engineers.plantmanagmementapp.model.UserHarvest;
import com.engineers.plantmanagmementapp.record.Pagination;
import com.engineers.plantmanagmementapp.rest.harvests.specification.model.*;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

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
    public abstract UserHarvest map(final UserHarvestDto userHarvest);

    @Mapping(source = "plantation.id", target = "plantationId")
    public abstract HarvestDto map(final Harvest harvest);

    public abstract List<HarvestDto> mapList(final List<Harvest> harvestList);

    public abstract List<UserHarvestDto> mapListOfUserHarvests(final List<UserHarvest> userHarvests);

    public PagedHarvestDto map(final Page<Harvest> page) {
        final PagedHarvestDto paged = new PagedHarvestDto();
        final PageDto pageDto = new PageDto();
        pageDto.setPage(page.getNumber());
        pageDto.setSize(page.getSize());
        pageDto.setTotalElements((int) page.getTotalElements());
        pageDto.setTotalPages(page.getTotalPages());

        paged.setPage(pageDto);
        paged.setData(mapList(page.getContent()));
        return paged;
    }

    public PagedUserHarvestDto mapUserHarvest(final Page<UserHarvest> page) {
        final PagedUserHarvestDto paged = new PagedUserHarvestDto();
        final PageDto pageDto = new PageDto();
        pageDto.setPage(page.getNumber());
        pageDto.setSize(page.getSize());
        pageDto.setTotalElements((int) page.getTotalElements());
        pageDto.setTotalPages(page.getTotalPages());

        paged.setPage(pageDto);
        paged.setData(mapListOfUserHarvests(page.getContent()));
        return paged;
    }

    @Mapping(target = "harvestId", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "sectorId", ignore = true)
    @Mapping(target = "plantationId", ignore = true)
    public abstract UserHarvestDto map(final UserHarvest userHarvest);

    @Mapping(target = "userHarvests", ignore = true)
    @Mapping(target = "plantation", ignore = true)
    public abstract Harvest map(final HarvestDto harvest);

    public OffsetDateTime map(final LocalDateTime localDateTime) {
        if (localDateTime == null) {
            return null;
        }
        final ZoneId zoneId = ZoneId.systemDefault();
        final ZoneOffset zoneOffset = zoneId.getRules()
                .getOffset(localDateTime);
        return localDateTime.atOffset(zoneOffset);
    }

    public LocalDateTime map(final OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }
        return offsetDateTime.toLocalDateTime();
    }
}
