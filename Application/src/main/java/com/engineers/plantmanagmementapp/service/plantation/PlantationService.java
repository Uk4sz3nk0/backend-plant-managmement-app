package com.engineers.plantmanagmementapp.service.plantation;

import com.engineers.plantmanagmementapp.model.Area;
import com.engineers.plantmanagmementapp.model.Plantation;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.record.AreaRecord;
import com.engineers.plantmanagmementapp.record.PlantationRecord;

import java.util.List;

public interface PlantationService {

    void createPlantation(final PlantationRecord plantation, final User user);

    void deletePlantation(final Long id);

    void editPlantation(final PlantationRecord plantation);

    void editArea(final AreaRecord area);

    void addArea(final AreaRecord area, final Long plantationId);

    void deleteArea(final Long areaId);

    Area getAreaById(final Long id);

    List<Area> getAreas();

    List<Area> getAreasByPlantation(final Long plantationId);

    Plantation getPlantationById(final Long id);

    List<Plantation> getPlantations();

    List<Plantation> getPlantationsByUser(final User user);

    void addEmployee(final Long plantationId, final Long userId);

    List<User> getEmployees(final Long plantationId);
}