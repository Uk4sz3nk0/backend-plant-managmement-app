package com.engineers.plantmanagmementapp.handler;

import com.engineers.plantmanagmementapp.rest.harvests.specification.model.*;

import java.time.LocalDate;

/**
 * HarvestsHandler - Handler interface for Harvest and UserHarvest object operations
 * Created on: 2023-11-25
 *
 * @author Łukasz Wodniak
 */

public interface HarvestsHandler {

    void handleAddHarvest(final HarvestDto harvest);

    void handleAddUserHarvest(final Long harvestId, final UserHarvestDto userHarvest);

    void handleDeleteHarvest(final Long id);

    void handleDeleteUserHarvest(final Long id);

    void handleEditHarvest(final HarvestDto harvest);

    void handleEditUserHarvest(final UserHarvestDto userHarvest);

    HarvestDto handleGetHarvestById(final Long id);

    PagedHarvestDto handleGetHarvests(final Long plantationId, final PaginationRequestDto paginationRequest);

    PagedHarvestDto handleGetHarvestsByDate(final Long plantationId, final LocalDate date, final PaginationRequestDto paginationRequest);

    PagedHarvestDto handleGetHarvestsBySeason(final Long plantationId, final Integer season, final PaginationRequestDto paginationRequest);

    PagedHarvestDto handleGetHarvestsInDateRange(final Long plantationId, final LocalDate startDate, final LocalDate endDate, final PaginationRequestDto paginationRequest);

    UserHarvestDto handleGetUserHarvestsById(final Long harvestId);

    PagedUserHarvestDto handleGetUserHarvests(final Long userId, final PaginationRequestDto paginationRequest);

    PagedUserHarvestDto handleGetUserHarvestsByPlantation(final Long userId, final Long plantationId, final PaginationRequestDto paginationRequest);

}
