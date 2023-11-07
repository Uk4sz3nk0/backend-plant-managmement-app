package com.engineers.plantmanagmementapp.service.plantation.impl;

import com.engineers.plantmanagmementapp.model.Area;
import com.engineers.plantmanagmementapp.model.Plantation;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.record.AreaRecord;
import com.engineers.plantmanagmementapp.record.PlantationRecord;
import com.engineers.plantmanagmementapp.repository.AreaRepository;
import com.engineers.plantmanagmementapp.repository.PlantationRepository;
import com.engineers.plantmanagmementapp.service.plantation.PlantationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlantationServiceImpl implements PlantationService {

    private final PlantationRepository plantationRepo;
    private final AreaRepository areaRepo;

    @Override
    public void createPlantation(final PlantationRecord plantation, final User user) {

    }

    @Override
    public void deletePlantation(final Long id) {
        plantationRepo.deleteById(id);
    }

    @Override
    public void editPlantation(final PlantationRecord plantation) {

    }

    @Override
    public void editArea(final AreaRecord area) {

    }

    @Override
    public Area getAreaById(final Long id) {
        return null;
    }

    @Override
    public List<Area> getAreas() {
        return areaRepo.findAll();
    }

    @Override
    public List<Area> getAreasByPlantation(final Long plantationId) {
        return null;
    }

    @Override
    public Plantation getPlantationById(final Long id) {
        return null;
    }

    @Override
    public List<Plantation> getPlantations() {
        return null;
    }

    @Override
    public List<Plantation> getPlantationsByUser(final User user) {
        return null;
    }
}
