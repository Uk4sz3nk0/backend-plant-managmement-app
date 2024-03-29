package com.engineers.plantmanagmementapp.service.harvests;

import com.engineers.plantmanagmementapp.model.*;
import com.engineers.plantmanagmementapp.record.Pagination;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

/**
 * HarvestService - Service interface
 * Created on: 2023-11-25
 *
 * @author Łukasz Wodniak
 */

public interface HarvestsService {

    void addHarvest(final Harvest harvest, final Plantation plantation, final List<UserHarvest> userHarvests);

    void addUserHarvest(final UserHarvest userHarvest, final Area sector, final User user, final Harvest harvest, final Plant plant);

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

    Page<UserHarvest> getUserHarvests(final User user, final Pagination pagination);

    Page<UserHarvest> getUserHarvestsByPlantation(final User user, final Plantation plantation, final Pagination pagination);

    void setPlantForUserHarvest(final Plant plant, final Long userHarvestId);

    void startUserHarvest(final Long userHarvestId);
    void endUserHarvest(final Long userHarvestId);
    List<Harvest> getFutureHarvest(final User user);

    List<UserHarvest> getUserHarvestByDate(final LocalDate date, final User user, final Long plantationId);
}
