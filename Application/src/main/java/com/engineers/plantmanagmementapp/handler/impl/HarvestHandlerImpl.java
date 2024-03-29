package com.engineers.plantmanagmementapp.handler.impl;

import com.engineers.plantmanagmementapp.handler.HarvestsHandler;
import com.engineers.plantmanagmementapp.mapper.HarvestsMapper;
import com.engineers.plantmanagmementapp.model.Area;
import com.engineers.plantmanagmementapp.model.Plant;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.model.UserHarvest;
import com.engineers.plantmanagmementapp.repository.*;
import com.engineers.plantmanagmementapp.rest.harvests.specification.model.*;
import com.engineers.plantmanagmementapp.service.harvests.HarvestsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private final PlantRepository plantRepository;
    private final UserRepository userRepo;

    @Override
    public void handleAddHarvest(final HarvestDto harvestDto) {
        final var plantation = plantationRepository.findById(harvestDto.getPlantationId())
                .orElseThrow();
        final List<UserHarvest> userHarvests = harvestDto.getUserHarvests() != null ? mapUserHarvestsDto(harvestDto.getUserHarvests()) : List.of();
        harvestsService.addHarvest(HarvestsMapper.INSTANCE.map(harvestDto), plantation, userHarvests);
    }

    @Override
    public void handleAddUserHarvest(final Long harvestId, final UserHarvestDto userHarvest) {
        final var sector = areaRepository.findById(userHarvest.getSectorId())
                .orElseThrow();
        final var user = userRepository.findById(userHarvest.getUserId())
                .orElseThrow();
        final var harvest = harvestRepository.findById(harvestId)
                .orElseThrow();
        final var plant = plantRepository.findById(userHarvest.getPlantId())
                .orElseThrow();
        harvestsService.addUserHarvest(HarvestsMapper.INSTANCE.map(userHarvest), sector, user, harvest, plant);
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

    @Override
    public void handleSetPlantForUserHarvest(final Long plantId, final Long userHarvestId) {
        final var plant = plantRepository.findById(plantId)
                .orElseThrow();
        harvestsService.setPlantForUserHarvest(plant, userHarvestId);
    }

    @Override
    public void handleStartHarvest(final Long userHarvestId) {
        harvestsService.startUserHarvest(userHarvestId);
    }

    @Override
    public void handleEndHarvest(final Long userHarvestId) {
        harvestsService.endUserHarvest(userHarvestId);
    }

    @Override
    public List<HarvestDto> handleGetFutureHarvests() {
        final User user = getUserFromContext();
        return HarvestsMapper.INSTANCE.mapList(harvestsService.getFutureHarvest(user));
    }

    @Override
    public List<UserHarvestDto> handleGetUserHarvestByDate(final LocalDate date, final Long plantationId) {
        final User user = getUserFromContext();
        return HarvestsMapper.INSTANCE.mapListOfUserHarvests(harvestsService.getUserHarvestByDate(date, user, plantationId));
    }

    private User getUserFromContext() {
        final Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        final String currentPrincipalEmail = authentication.getName();
        return userRepo.findByEmail(currentPrincipalEmail)
                .orElseThrow();
    }

    private List<UserHarvest> mapUserHarvestsDto(final List<UserHarvestDto> list) {
        final List<UserHarvest> results = new ArrayList<>();
        list.forEach(userHarvestDto -> {
            final UserHarvest userHarvest = new UserHarvest();
            final Area sector = areaRepository.findById(userHarvestDto.getSectorId())
                    .orElseThrow();
            final User employee = userRepository.findById(userHarvestDto.getUserId())
                    .orElseThrow();
            final Plant plant = plantRepository.findById(userHarvestDto.getPlantId())
                    .orElseThrow();
            userHarvest.setSector(sector);
            userHarvest.setUser(employee);
            userHarvest.setRow(userHarvestDto.getRow());
            userHarvest.setPlant(plant);
            results.add(userHarvest);
        });
        return results;
    }
}
