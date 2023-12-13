package com.engineers.plantmanagmementapp.handler;

import com.engineers.plantmanagmementapp.rest.user_stats.specification.model.PageRequestDto;
import com.engineers.plantmanagmementapp.rest.user_stats.specification.model.PagedStatsDto;
import com.engineers.plantmanagmementapp.rest.user_stats.specification.model.UserStatsDto;

/**
 * UserStatsHandler - handler for user stats
 * Created on: 2023-12-13
 *
 * @author Łukasz Wodniak
 */

public interface UserStatsHandler {

    UserStatsDto handleGetStatsByHarvest(final Long harvestId, final Long userId);

    PagedStatsDto handleGetStatsByUser(final Long userId, final PageRequestDto pageRequest);

    void handleReportCollected(final Long userId, final Long harvestId);
}
