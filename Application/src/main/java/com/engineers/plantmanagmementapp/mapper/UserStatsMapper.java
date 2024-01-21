package com.engineers.plantmanagmementapp.mapper;

import com.engineers.plantmanagmementapp.model.UserStats;
import com.engineers.plantmanagmementapp.record.Pagination;
import com.engineers.plantmanagmementapp.rest.user_stats.specification.model.PageDto;
import com.engineers.plantmanagmementapp.rest.user_stats.specification.model.PageRequestDto;
import com.engineers.plantmanagmementapp.rest.user_stats.specification.model.PagedStatsDto;
import com.engineers.plantmanagmementapp.rest.user_stats.specification.model.UserStatsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * UserStatsMapper - Mapper class for objects used with UserStats
 * Created on: 2023-12-13
 *
 * @author Łukasz Wodniak
 */

@Mapper
public abstract class UserStatsMapper {

    public static UserStatsMapper INSTANCE = Mappers.getMapper(UserStatsMapper.class);

    public abstract Pagination map(final PageRequestDto pageRequest);

    @Mapping(source = "harvest.id", target = "harvestId")
    @Mapping(source = "user.id", target = "userId")
    public abstract UserStatsDto map(final UserStats userStats);

    public abstract List<UserStatsDto> map(final List<UserStats> userStatsList);

    public PagedStatsDto map(final Page<UserStats> page) {
        final PagedStatsDto paged = new PagedStatsDto();
        final PageDto pageDto = new PageDto();
        pageDto.setPage(page.getNumber());
        pageDto.setSize(page.getSize());
        pageDto.setTotalElements((int) page.getTotalElements());
        pageDto.setTotalPages(page.getTotalPages());

        paged.setPage(pageDto);
        paged.setData(map(page.getContent()));
        return paged;
    }
}
