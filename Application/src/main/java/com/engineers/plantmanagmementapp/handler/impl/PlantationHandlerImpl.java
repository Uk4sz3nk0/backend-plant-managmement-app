package com.engineers.plantmanagmementapp.handler.impl;

import com.engineers.plantmanagmementapp.handler.PlantationHandler;
import com.engineers.plantmanagmementapp.mapper.PlantationMapper;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.repository.UserRepository;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.AreaDto;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.PlantationDto;
import com.engineers.plantmanagmementapp.service.plantation.PlantationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PlantationHandlerImpl - Real implementation of plantation handler
 * <p>
 * Created on: 2023-11-06
 *
 * @author Łuaksz Wodniak
 */

@Slf4j
@Service
@Primary
@RequiredArgsConstructor
public class PlantationHandlerImpl implements PlantationHandler {

    private final PlantationService plantationService;
    private final UserRepository userRepo;

    @Override
    public void handleCreatePlantation(final PlantationDto plantationDto) {
        final var currentUser = getUserFromContext();
        plantationService.createPlantation(PlantationMapper.INSTANCE.map(plantationDto), currentUser);
    }

    @Override
    public void handleDeletePlantation(final Long plantationId) {
        plantationService.deletePlantation(plantationId);
    }

    @Override
    public void handleEditPlantation(final PlantationDto plantationDto) {
        plantationService.editPlantation(PlantationMapper.INSTANCE.map(plantationDto));
    }

    @Override
    public void handleEditArea(final AreaDto areaDto) {
        plantationService.editArea(PlantationMapper.INSTANCE.map(areaDto));
    }

    @Override
    public AreaDto handleGetAreaById(final Long areaId) {
        return PlantationMapper.INSTANCE.map(plantationService.getAreaById(areaId));
    }

    @Override
    public List<AreaDto> handleGetAreas() {
        return PlantationMapper.INSTANCE.map(plantationService.getAreas());
    }

    @Override
    public List<AreaDto> handleGetAreasByPlantation(final Long plantationId) {
        return PlantationMapper.INSTANCE.map(plantationService.getAreasByPlantation(plantationId));
    }

    @Override
    public PlantationDto handleGetPlantationById(final Long plantationId) {
        return PlantationMapper.INSTANCE.map(plantationService.getPlantationById(plantationId));
    }

    @Override
    public List<PlantationDto> handleGetPlantations() {
        return PlantationMapper.INSTANCE.mapToDtoList(plantationService.getPlantations());
    }

    @Override
    public List<PlantationDto> handleGetPlantationsByUser(final Long userId) {
        final var user = userRepo.findById(userId).orElseThrow();
        return PlantationMapper.INSTANCE.mapToDtoList(plantationService.getPlantationsByUser(user));
    }

    private User getUserFromContext() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final String currentPrincipalEmail = authentication.getName();
        return userRepo.findByEmail(currentPrincipalEmail).orElseThrow();
    }
}
