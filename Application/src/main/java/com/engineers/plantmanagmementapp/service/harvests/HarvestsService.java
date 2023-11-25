package com.engineers.plantmanagmementapp.service.harvests;

import com.engineers.plantmanagmementapp.model.*;
import com.engineers.plantmanagmementapp.record.Pagination;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

/**
 * HarvestService - Service interface
 * Created on: 2023-11-25
 *
 * @author Łukasz Wodniak
 */

public interface HarvestsService {

    void addHarvest(final Harvest harvest);

    void addUserHarvest(final UserHarvest userHarvest, final Area sector, final User user, final Harvest harvest, final Plantation plantation);

    void deleteHarvest(final Long id);

    void deleteUserHarvest(final Long id);

    void editHarvest(final Harvest harvest);

    void editUserHarvest(final UserHarvest userHarvest, final Area sector, final User user);

    Harvest getHarvestById(final Long id);

    Page<Harvest> getHarvests(final Long plantationId, final Pagination pagination);

    Page<Harvest> getHarvestsByDate(final Long plantationId, final LocalDate date, final Pagination pagination);

    Page<Harvest> getHarvestsBySeason(final Long plantationId, final Integer season, final Pagination pagination);

    Page<Harvest> getHarvestsInDateRange(final Long plantationId, final LocalDate startDate, final LocalDate endDate, final Pagination pagination);

    UserHarvest getUserHarvestById(final Long id);

    Page<UserHarvest> getUserHarvests(final Long userId, final Pagination pagination);

    Page<UserHarvest> getUserHarvestsByPlantation(final Long userId, final Long plantationId);

}
