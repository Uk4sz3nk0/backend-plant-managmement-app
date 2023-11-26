package com.engineers.plantmanagmementapp.handler.impl;

import com.engineers.plantmanagmementapp.handler.HarvestsHandler;
import com.engineers.plantmanagmementapp.mapper.HarvestsMapper;
import com.engineers.plantmanagmementapp.repository.AreaRepository;
import com.engineers.plantmanagmementapp.repository.HarvestRepository;
import com.engineers.plantmanagmementapp.repository.PlantationRepository;
import com.engineers.plantmanagmementapp.repository.UserRepository;
import com.engineers.plantmanagmementapp.rest.harvests.specification.model.*;
import com.engineers.plantmanagmementapp.service.harvests.HarvestsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * HarvestHandlerImpl - Implementation class of PlantationHandler interface
 * Created on: 2023-11-25
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@RequiredArgsConstructor
@Service
@Primary
public class HarvestHandlerImpl implements HarvestsHandler {

    private final HarvestsService harvestsService;
    private final AreaRepository areaRepository;
    private final UserRepository userRepository;
    private final HarvestRepository harvestRepository;
    private final PlantationRepository plantationRepository;

    @Override
    public void handleAddHarvest(final HarvestDto harvestDto) {
        final var plantation = plantationRepository.findById(harvestDto.getPlantationId())
                .orElseThrow();
        harvestsService.addHarvest(HarvestsMapper.INSTANCE.map(harvestDto), plantation);
    }

    @Override
    public void handleAddUserHarvest(final Long harvestId, final UserHarvestDto userHarvest) {
        final var sector = areaRepository.findById(userHarvest.getSectorId())
                .orElseThrow();
        final var user = userRepository.findById(userHarvest.getUserId())
                .orElseThrow();
        final var harvest = harvestRepository.findById(harvestId)
                .orElseThrow();
        harvestsService.addUserHarvest(HarvestsMapper.INSTANCE.map(userHarvest), sector, user, harvest);
    }

    @Override
    public void handleDeleteHarvest(final Long id) {
        harvestsService.deleteHarvest(id);
    }

    @Override
    public void handleDeleteUserHarvest(final Long id) {
        harvestsService.deleteUserHarvest(id);
    }

    @Override
    public void handleEditHarvest(final HarvestDto harvest) {
        harvestsService.editHarvest(HarvestsMapper.INSTANCE.map(harvest));
    }

    @Override
    public void handleEditUserHarvest(final UserHarvestDto userHarvest) {
        final var sector = areaRepository.findById(userHarvest.getSectorId())
                .orElseThrow();
        final var user = userRepository.findById(userHarvest.getUserId())
                .orElseThrow();
        harvestsService.editUserHarvest(HarvestsMapper.INSTANCE.map(userHarvest), sector, user);
    }

    @Override
    public HarvestDto handleGetHarvestById(final Long id) {
        return HarvestsMapper.INSTANCE.map(harvestsService.getHarvestById(id));
    }

    @Override
    public PagedHarvestDto handleGetHarvests(final Long plantationId, final PaginationRequestDto paginationRequest) {
        final var pagination = HarvestsMapper.INSTANCE.map(paginationRequest);
        return HarvestsMapper.INSTANCE.map(harvestsService.getHarvests(plantationId, pagination));
    }

    @Override
    public PagedHarvestDto handleGetHarvestsByDate(final Long plantationId, final LocalDate date, final PaginationRequestDto paginationRequest) {
        final var pagination = HarvestsMapper.INSTANCE.map(paginationRequest);
        return HarvestsMapper.INSTANCE.map(harvestsService.getHarvestsByDate(plantationId, date, pagination));
    }

    @Override
    public PagedHarvestDto handleGetHarvestsBySeason(final Long plantationId, final Integer season, final PaginationRequestDto paginationRequest) {
        final var pagination = HarvestsMapper.INSTANCE.map(paginationRequest);
        return HarvestsMapper.INSTANCE.map(harvestsService.getHarvestsBySeason(plantationId, season, pagination));
    }

    @Override
    public PagedHarvestDto handleGetHarvestsInDateRange(final Long plantationId, final LocalDate startDate, final LocalDate endDate, final PaginationRequestDto paginationRequest) {
        final var pagination = HarvestsMapper.INSTANCE.map(paginationRequest);
        return HarvestsMapper.INSTANCE.map(harvestsService.getHarvestsInDateRange(plantationId, startDate, endDate, pagination));
    }

    @Override
    public UserHarvestDto handleGetUserHarvestsById(final Long harvestId) {
        return HarvestsMapper.INSTANCE.map(harvestsService.getUserHarvestById(harvestId));
    }

    @Override
    public PagedUserHarvestDto handleGetUserHarvests(final Long userId, final PaginationRequestDto paginationRequest) {
        final var pagination = HarvestsMapper.INSTANCE.map(paginationRequest);
        final var user = userRepository.findById(userId)
                .orElseThrow();
        return HarvestsMapper.INSTANCE.mapUserHarvest(harvestsService.getUserHarvests(user, pagination));
    }

    @Override
    public PagedUserHarvestDto handleGetUserHarvestsByPlantation(final Long userId, final Long plantationId, final PaginationRequestDto paginationRequest) {
        final var user = userRepository.findById(userId)
                .orElseThrow();
        final var plantation = plantationRepository.findById(plantationId)
                .orElseThrow();
        final var pagination = HarvestsMapper.INSTANCE.map(paginationRequest);
        return HarvestsMapper.INSTANCE.mapUserHarvest(harvestsService.getUserHarvestsByPlantation(user, plantation, pagination));
    }
}
