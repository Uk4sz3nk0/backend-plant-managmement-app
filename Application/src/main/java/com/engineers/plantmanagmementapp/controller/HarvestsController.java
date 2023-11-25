package com.engineers.plantmanagmementapp.controller;

import com.engineers.plantmanagmementapp.handler.HarvestsHandler;
import com.engineers.plantmanagmementapp.rest.harvests.specification.api.HarvestsApi;
import com.engineers.plantmanagmementapp.rest.harvests.specification.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * HarvestsController - Controller class for any things connected with harvests
 * <p>
 * Created on: 2023-11-25
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@RestController
@RequiredArgsConstructor
public class HarvestsController implements HarvestsApi {

    private final HarvestsHandler harvestsHandler;

    @Override
    public ResponseEntity<Void> addHarvest(final HarvestDto harvest) {
        log.info("Request 'addHarvest' has called");
        harvestsHandler.handleAddHarvest(harvest);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> addUserHarvest(final Long harvestId, final UserHarvestDto userHarvest) {
        log.info("Request 'addUserHarvest' has called");
        harvestsHandler.handleAddUserHarvest(harvestId, userHarvest);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> deleteHarvest(final Long harvestId) {
        log.info("Request 'deleteHarvest' has called");
        harvestsHandler.handleDeleteHarvest(harvestId);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> deleteUserHarvest(final Long userHarvestId) {
        log.info("Request 'deleteUserHarvest' has called");
        harvestsHandler.handleDeleteUserHarvest(userHarvestId);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> editHarvest(final HarvestDto harvest) {
        log.info("Request 'editHarvest' has called");
        harvestsHandler.handleEditHarvest(harvest);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<Void> editUserHarvest(final UserHarvestDto userHarvest) {
        log.info("Request 'editUserHarvest' has called");
        harvestsHandler.handleEditUserHarvest(userHarvest);
        return ResponseEntity.ok(null);
    }

    @Override
    public ResponseEntity<HarvestDto> getHarvestById(final Long id) {
        log.info("Request 'getHarvestById' has called");
        return ResponseEntity.ok(harvestsHandler.handleGetHarvestById(id));
    }

    @Override
    public ResponseEntity<PagedHarvestDto> getHarvests(final Long plantationId, final PaginationRequestDto paginationRequestDto) {
        log.info("Request 'getHarvests' has called");
        return ResponseEntity.ok(harvestsHandler.handleGetHarvests(plantationId, paginationRequestDto));
    }

    @Override
    public ResponseEntity<PagedHarvestDto> getHarvestsByDate(final Long plantationId, final LocalDate date, final PaginationRequestDto paginationRequestDto) {
        log.info("Request 'getHarvestsByDate' has called");
        return ResponseEntity.ok(harvestsHandler.handleGetHarvestsByDate(plantationId, date, paginationRequestDto));
    }

    @Override
    public ResponseEntity<PagedHarvestDto> getHarvestsBySeason(final Long plantationId, final Integer season, final PaginationRequestDto paginationRequestDto) {
        log.info("Request 'getHarvestsBySeason' has called");
        return ResponseEntity.ok(harvestsHandler.handleGetHarvestsBySeason(plantationId, season, paginationRequestDto));
    }

    @Override
    public ResponseEntity<PagedHarvestDto> getHarvestsInDateRange(Long plantationId, LocalDate startDate, LocalDate endDate, PaginationRequestDto body) {
        return HarvestsApi.super.getHarvestsInDateRange(plantationId, startDate, endDate, body);
    }

    @Override
    public ResponseEntity<UserHarvestDto> getUserHarvestById(Long harvestId) {
        return HarvestsApi.super.getUserHarvestById(harvestId);
    }

    @Override
    public ResponseEntity<PagedUserHarvestDto> getUserHarvests(Long userId, PaginationRequestDto body) {
        return HarvestsApi.super.getUserHarvests(userId, body);
    }

    @Override
    public ResponseEntity<PagedUserHarvestDto> getUserHarvestsByPlantation(Long userId, Long plantationId, PaginationRequestDto body) {
        return HarvestsApi.super.getUserHarvestsByPlantation(userId, plantationId, body);
    }
}
