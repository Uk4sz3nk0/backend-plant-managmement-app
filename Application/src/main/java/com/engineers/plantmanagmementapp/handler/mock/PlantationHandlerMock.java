package com.engineers.plantmanagmementapp.handler.mock;

import com.engineers.plantmanagmementapp.handler.PlantationHandler;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.AreaDto;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.CoordinateDto;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.PlantationDto;
import com.engineers.plantmanagmementapp.rest.plantation.specification.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * PlantationHandlerMock - Mock implementation of plantation handler
 * <p>
 * Created on: 2023-11-06
 *
 * @author Łukasz Wodniak
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class PlantationHandlerMock implements PlantationHandler {

    @Override
    public void handleCreatePlantation(final PlantationDto plantationDto) {

    }

    @Override
    public void handleDeletePlantation(final Long plantationId) {

    }

    @Override
    public void handleEditPlantation(final PlantationDto plantationDto) {

    }

    @Override
    public void handleAddArea(final AreaDto area, final Long plantationId) {

    }

    @Override
    public void handleEditArea(final AreaDto areaDto) {

    }

    @Override
    public AreaDto handleGetAreaById(final Long areaId) {
        return generateArea(areaId);
    }

    @Override
    public void handleDeleteArea(final Long areaId) {

    }

    @Override
    public List<AreaDto> handleGetAreas() {
        return List.of(
                generateArea(1L),
                generateArea(2L),
                generateArea(3L),
                generateArea(4L)
        );
    }

    @Override
    public List<AreaDto> handleGetAreasByPlantation(final Long plantationId) {
        return List.of(
                generateArea(1L),
                generateArea(2L),
                generateArea(3L),
                generateArea(4L),
                generateArea(5L)
        );
    }

    @Override
    public PlantationDto handleGetPlantationById(final Long plantationId) {
        return generatePlantation(plantationId);
    }

    @Override
    public List<PlantationDto> handleGetPlantations() {
        return List.of(
                generatePlantation(1L),
                generatePlantation(2L),
                generatePlantation(3L),
                generatePlantation(4L),
                generatePlantation(5L),
                generatePlantation(6L)
        );
    }

    @Override
    public List<PlantationDto> handleGetPlantationsByUser(final Long userId) {
        return List.of(
                generatePlantation(1L),
                generatePlantation(2L)
        );
    }

    @Override
    public void handleAddEmployee(final Long plantationId, final Long userId) {

    }

    @Override
    public List<UserDto> handleGetEmployees(Long plantationId) {
        return null;
    }

    @Override
    public List<PlantationDto> handleGetUserWorkedInPlantations() {
        return null;
    }

    private PlantationDto generatePlantation(final Long id) {
        final PlantationDto plantation = new PlantationDto();
        plantation.setId(id);
        plantation.setName("Plantation_" + id);
        plantation.setArea(generateArea(id));
        plantation.setCity("Kraków");
        plantation.setNip("12332145654");
        plantation.setHouseNumber(4);
        plantation.setSectors(List.of(
                generateArea(1L),
                generateArea(2L),
                generateArea(3L),
                generateArea(4L),
                generateArea(5L)
        ));
        return plantation;
    }

    private AreaDto generateArea(final Long id) {
        final AreaDto area = new AreaDto();
        area.setId(id);
        area.setName("Area_" + id);
        area.setPolygonColor("#32a852");
        area.setCoordinates(List.of(
                generateCoordinate(1L),
                generateCoordinate(2L),
                generateCoordinate(3L),
                generateCoordinate(4L)
        ));
        return area;
    }

    private CoordinateDto generateCoordinate(final Long id) {
        final CoordinateDto coordinate = new CoordinateDto();
        coordinate.setId(id);
        coordinate.setLatitude(new Random().nextDouble());
        coordinate.setLongitude(new Random().nextDouble());
        return coordinate;
    }
}
