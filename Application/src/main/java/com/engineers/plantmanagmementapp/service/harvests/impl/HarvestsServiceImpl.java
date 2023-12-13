package com.engineers.plantmanagmementapp.service.harvests.impl;

import com.engineers.plantmanagmementapp.model.*;
import com.engineers.plantmanagmementapp.record.Pagination;
import com.engineers.plantmanagmementapp.repository.HarvestRepository;
import com.engineers.plantmanagmementapp.repository.PlantationRepository;
import com.engineers.plantmanagmementapp.repository.UserHarvestRepository;
import com.engineers.plantmanagmementapp.service.harvests.HarvestsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    private final HarvestRepository harvestRepository;
    private final UserHarvestRepository userHarvestRepository;
    private final PlantationRepository plantationRepository;

    @Override
    public void addHarvest(final Harvest harvest, final Plantation plantation) {
        harvest.setPlantation(plantation);
        harvestRepository.saveAndFlush(harvest);
    }

    @Override
    public void addUserHarvest(final UserHarvest userHarvest, final Area sector, final User user, final Harvest harvest) {
        userHarvest.setHarvest(harvest);
        userHarvest.setSector(sector);
        userHarvest.setUser(user);
        harvest.getUserHarvests()
                .add(userHarvest);
        harvestRepository.saveAndFlush(harvest);
    }

    @Override
    public void deleteHarvest(final Long id) {
        harvestRepository.deleteById(id);
    }

    @Override
    public void deleteUserHarvest(final Long id) {
        userHarvestRepository.deleteById(id);
    }

    @Override
    public void editHarvest(final Harvest harvest) {
        final var editHarvest = harvestRepository.findById(harvest.getId())
                .orElseThrow();
        editHarvest.setDate(harvest.getDate());
        editHarvest.setSeason(harvest.getSeason());
        harvestRepository.saveAndFlush(editHarvest);
    }

    @Override
    public void editUserHarvest(final UserHarvest userHarvest, final Area sector, final User user) {
        final var editUserHarvest = userHarvestRepository.findById(userHarvest.getId())
                .orElseThrow();
        editUserHarvest.setUser(user);
        editUserHarvest.setHarvestStart(userHarvest.getHarvestStart());
        editUserHarvest.setHarvestEnd(userHarvest.getHarvestEnd());
        editUserHarvest.setSector(sector);
        editUserHarvest.setRow(userHarvest.getRow());
        // TODO: Implement setting plant
//        editUserHarvest.setPlantName(userHarvest.getPlantName());
        userHarvestRepository.saveAndFlush(editUserHarvest);
    }

    @Override
    public Harvest getHarvestById(final Long id) {
        return harvestRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Page<Harvest> getHarvests(final Long plantationId, final Pagination pagination) {
        final var plantation = plantationRepository.findById(plantationId)
                .orElseThrow();
        return harvestRepository.findAllByPlantation(plantation, PageRequest.of(pagination.page(), pagination.size()));
    }

    @Override
    public Page<Harvest> getHarvestsByDate(final Long plantationId, final LocalDate date, final Pagination pagination) {
        final var plantation = plantationRepository.findById(plantationId)
                .orElseThrow();
        return harvestRepository.findAllByPlantationAndDate(plantation, date, PageRequest.of(pagination.page(), pagination.size()));
    }

    @Override
    public Page<Harvest> getHarvestsBySeason(final Long plantationId, final Integer season, final Pagination pagination) {
        final var plantation = plantationRepository.findById(plantationId)
                .orElseThrow();
        return harvestRepository.findAllByPlantationAndSeason(plantation, season, PageRequest.of(pagination.page(), pagination.size()));
    }

    @Override
    public Page<Harvest> getHarvestsInDateRange(final Long plantationId, final LocalDate startDate, final LocalDate endDate, final Pagination pagination) {
        return harvestRepository.findAllByPlantationInDateRange(plantationId, startDate, endDate, PageRequest.of(pagination.page(), pagination.size()));
    }

    @Override
    public UserHarvest getUserHarvestById(final Long id) {
        return userHarvestRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Page<UserHarvest> getUserHarvests(final User user, final Pagination pagination) {
        return userHarvestRepository.findAllByUser(user, PageRequest.of(pagination.page(), pagination.size()));
    }

    @Override
    public Page<UserHarvest> getUserHarvestsByPlantation(final User user, final Plantation plantation, final Pagination pagination) {
        return userHarvestRepository.findAllByUserAndPlantation(user, plantation, PageRequest.of(pagination.page(), pagination.size()));
    }

    @Override
    public void setPlantForUserHarvest(final Plant plant, final Long userHarvestId) {
        final var userHarvest = userHarvestRepository.findById(userHarvestId)
                .orElseThrow();
        userHarvest.setPlant(plant);
        userHarvestRepository.saveAndFlush(userHarvest);
    }
}
