package com.engineers.plantmanagmementapp.handler.impl;

import com.engineers.plantmanagmementapp.handler.UserStatsHandler;
import com.engineers.plantmanagmementapp.mapper.UserStatsMapper;
import com.engineers.plantmanagmementapp.model.Harvest;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.repository.HarvestRepository;
import com.engineers.plantmanagmementapp.repository.UserRepository;
import com.engineers.plantmanagmementapp.rest.user_stats.specification.model.PageRequestDto;
import com.engineers.plantmanagmementapp.rest.user_stats.specification.model.PagedStatsDto;
import com.engineers.plantmanagmementapp.rest.user_stats.specification.model.UserStatsDto;
import com.engineers.plantmanagmementapp.service.userStats.UserStatsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * UserStatsHandlerImpl - Implementation of user handler service
 * Created on: 2023-12-13
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@RequiredArgsConstructor
@Primary
@Service
public class UserStatsHandlerImpl implements UserStatsHandler {

    private final UserStatsService userStatsService;
    private final UserRepository userRepo;
    private final HarvestRepository harvestRepo;


    @Override
    public UserStatsDto handleGetStatsByHarvest(final Long harvestId, final Long userId) {
        final Harvest harvest = harvestRepo.findById(harvestId)
                .orElseThrow();
        final User user = userRepo.findById(userId)
                .orElseThrow();
        return UserStatsMapper.INSTANCE.map(userStatsService.getStatsByHarvest(harvest, user));
    }

    @Override
    public PagedStatsDto handleGetStatsByUser(final Long userId, final PageRequestDto pageRequest) {
        final User user = userRepo.findById(userId)
                .orElseThrow();
        return UserStatsMapper.INSTANCE.map(userStatsService.getStatsByUser(user, UserStatsMapper.INSTANCE.map(pageRequest)));
    }

    @Override
    public void handleReportCollected(final Long userId, final Long harvestId) {
        final Harvest harvest = harvestRepo.findById(harvestId)
                .orElseThrow();
        final User user = userRepo.findById(userId)
                .orElseThrow();
        userStatsService.reportCollected(harvest, user);

    }
}
