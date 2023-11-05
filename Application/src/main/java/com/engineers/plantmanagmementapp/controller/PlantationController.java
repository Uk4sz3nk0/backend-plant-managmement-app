package com.engineers.plantmanagmementapp.controller;

import com.engineers.plantmanagmementapp.rest.plantation.specification.api.PlantationApi;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.PlantationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * PlantationController
 * <p>
 * Created on: 2023-11-05
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@RestController
@RequiredArgsConstructor
public class PlantationController implements PlantationApi {


    @Override
    public ResponseEntity<Void> createPlantation(final PlantationDto plantationDto) {
        log.info("Endpoint \"createPlantation\" has called");
        return PlantationApi.super.createPlantation(plantationDto);
    }

    @Override
    public ResponseEntity<Void> deletePlantation(final Long id) {
        log.info("Endpoint \"deletePlantation\" has called");
        return PlantationApi.super.deletePlantation(id);
    }

    @Override
    public ResponseEntity<Void> editPlantation(final PlantationDto plantationDto) {
        log.info("Endpoint \"editPlantation\" has called");
        return PlantationApi.super.editPlantation(plantationDto);
    }
}
