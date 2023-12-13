package com.engineers.plantmanagmementapp.service.userStats;

import com.engineers.plantmanagmementapp.model.Harvest;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.model.UserStats;
import com.engineers.plantmanagmementapp.record.Pagination;
import org.springframework.data.domain.Page;

/**
 * UserStatsService - interface of user stats service
 * Created on: 2023-12-13
 *
 * @author Łukasz Wodniak
 */

public interface UserStatsService {

    UserStats getStatsByHarvest(final Harvest harvest, final User user);

    Page<UserStats> getStatsByUser(final User user, final Pagination pagination);

    void reportCollected(final Harvest harvest, final User user);
}
