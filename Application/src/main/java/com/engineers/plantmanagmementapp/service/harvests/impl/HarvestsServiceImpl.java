package com.engineers.plantmanagmementapp.service.harvests.impl;

import com.engineers.plantmanagmementapp.model.Harvest;
import com.engineers.plantmanagmementapp.model.UserHarvest;
import com.engineers.plantmanagmementapp.record.Pagination;
import com.engineers.plantmanagmementapp.service.harvests.HarvestsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * HarvestServiceImpl - Implementation of HarvestService interface
 * Created on: 2023-11-25
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@RequiredArgsConstructor
@Service
public class HarvestsServiceImpl implements HarvestsService {

    @Override
    public void addHarvest(final Harvest harvest) {
    }

    @Override
    public void addUserHarvest(final UserHarvest userHarvest, final Long sectorId, final Long userId, final Long harvestId, final Long plantationId) {

    }

    @Override
    public void deleteHarvest(final Long id) {

    }

    @Override
    public void deleteUserHarvest(final Long id) {

    }

    @Override
    public void editHarvest(final Harvest harvest) {

    }

    @Override
    public void editUserHarvest(final UserHarvest userHarvest, final Long sectorId, final Long userId) {

    }

    @Override
    public Harvest getHarvestById(final Long id) {
        return null;
    }

    @Override
    public Page<Harvest> getHarvests(final Long plantationId, final Pagination pagination) {
        return null;
    }

    @Override
    public Page<Harvest> getHarvestsByDate(final Long plantationId, final LocalDate date, final Pagination pagination) {
        return null;
    }

    @Override
    public Page<Harvest> getHarvestsBySeason(final Long plantationId, final Integer season, final Pagination pagination) {
        return null;
    }

    @Override
    public Page<Harvest> getHarvestsInDateRange(final Long plantationId, final LocalDate startDate, final LocalDate endDate, final Pagination pagination) {
        return null;
    }

    @Override
    public UserHarvest getUserHarvestById(final Long id) {
        return null;
    }

    @Override
    public Page<UserHarvest> getUserHarvests(final Long userId, final Pagination pagination) {
        return null;
    }

    @Override
    public Page<UserHarvest> getUserHarvestsByPlantation(final Long userId, final Long plantationId) {
        return null;
    }
}
