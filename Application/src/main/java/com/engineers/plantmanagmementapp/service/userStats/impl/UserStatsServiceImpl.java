package com.engineers.plantmanagmementapp.service.userStats.impl;

import com.engineers.plantmanagmementapp.model.Harvest;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.model.UserStats;
import com.engineers.plantmanagmementapp.record.Pagination;
import com.engineers.plantmanagmementapp.repository.UserStatsRepository;
import com.engineers.plantmanagmementapp.service.userStats.UserStatsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * UserStatsServiceImpl - Implementation of UserStatsService interface
 * Created on: 2023-12-13
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class UserStatsServiceImpl implements UserStatsService {

    private final UserStatsRepository userStatsRepo;

    @Override
    public UserStats getStatsByHarvest(final Harvest harvest, final User user) {
        return userStatsRepo.findByHarvestAndUser(harvest, user)
                .orElseThrow();
    }

    @Override
    public Page<UserStats> getStatsByUser(final User user, final Pagination pagination) {
        return userStatsRepo.findAllByUser(user, PageRequest.of(pagination.page(), pagination.size()));
    }

    @Override
    public void reportCollected(final Harvest harvest, final User user) {
        final UserStats updatedStats = userStatsRepo.findByHarvestAndUser(harvest, user).orElseThrow();
        updatedStats.setCollectedContainers(updatedStats.getCollectedContainers() + 1);
        userStatsRepo.save(updatedStats);
    }
}
