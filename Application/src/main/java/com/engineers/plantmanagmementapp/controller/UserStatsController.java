package com.engineers.plantmanagmementapp.controller;

import com.engineers.plantmanagmementapp.handler.UserStatsHandler;
import com.engineers.plantmanagmementapp.rest.user_stats.specification.api.UserStatsApi;
import com.engineers.plantmanagmementapp.rest.user_stats.specification.model.PageRequestDto;
import com.engineers.plantmanagmementapp.rest.user_stats.specification.model.PagedStatsDto;
import com.engineers.plantmanagmementapp.rest.user_stats.specification.model.UserStatsDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserStatsController - controller class for user stats operations
 * Created on: 2023-12-13
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserStatsController implements UserStatsApi {

    private final UserStatsHandler userStatsHandler;

    @Override
    public ResponseEntity<UserStatsDto> getStatsByHarvest(final Long harvestId, final Long userId) {
        log.info("Endpoint \"getStatsByHarvest\" has called");
        return ResponseEntity.ok(userStatsHandler.handleGetStatsByHarvest(harvestId, userId));
    }

    @Override
    public ResponseEntity<PagedStatsDto> getStatsByUser(final Long userId, final PageRequestDto pageRequest) {
        log.info("Endpoint \"getStatsByUser\" has called");
        return ResponseEntity.ok(userStatsHandler.handleGetStatsByUser(userId, pageRequest));
    }

    @Override
    public ResponseEntity<Void> reportCollected(final Long userId, final Long harvestId) {
        log.info("Endpoint \"reportCollected\" has called");
        userStatsHandler.handleReportCollected(userId, harvestId);
        return ResponseEntity.ok(null);
    }
}
