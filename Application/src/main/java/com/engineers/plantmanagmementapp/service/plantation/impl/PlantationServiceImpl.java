package com.engineers.plantmanagmementapp.service.plantation.impl;

import com.engineers.plantmanagmementapp.mapper.PlantationMapper;
import com.engineers.plantmanagmementapp.model.Area;
import com.engineers.plantmanagmementapp.model.Plantation;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.record.AreaRecord;
import com.engineers.plantmanagmementapp.record.PlantationRecord;
import com.engineers.plantmanagmementapp.repository.AreaRepository;
import com.engineers.plantmanagmementapp.repository.PlantationRepository;
import com.engineers.plantmanagmementapp.repository.UserRepository;
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
    private final UserRepository userRepo;

    @Override
    public void createPlantation(final PlantationRecord plantation, final User user) {
        final Plantation newPlantation = new Plantation();
        assignPlantationData(plantation, newPlantation);
        final Area mainArea = PlantationMapper.INSTANCE.map(plantation.area());
        mainArea.setPlantations(List.of(newPlantation));
        newPlantation.setArea(mainArea);
        newPlantation.setOwner(user);
        plantationRepo.saveAndFlush(newPlantation);
    }

    @Override
    public void deletePlantation(final Long id) {
        plantationRepo.deleteById(id);
    }

    @Override
    public void editPlantation(final PlantationRecord plantation) {
        final var editedPlantation = plantationRepo.findById(plantation.id())
                .orElseThrow();
        assignPlantationData(plantation, editedPlantation);
        plantationRepo.save(editedPlantation);
    }

    @Override
    public void addArea(final AreaRecord area, final Long plantationId) {
        // TODO: Fully implement adding area
        final Area newArea = new Area();
        newArea.setIsMainArea(area.isMainArea());
        newArea.setName(area.name());
        newArea.setPolygonColor(area.polygonColor());
//        newArea.setPlantations();
//        newArea.setCoordinates();
        areaRepo.saveAndFlush(newArea);
    }

    @Override
    public void editArea(final AreaRecord area) {
        final var editedArea = areaRepo.findById(area.id())
                .orElseThrow();
        editedArea.setName(area.name());
        editedArea.setPolygonColor(area.polygonColor());
        editedArea.setCoordinates(PlantationMapper.INSTANCE.mapCords(area.coordinates()));
        areaRepo.save(editedArea);
    }

    @Override
    public void deleteArea(final Long areaId) {
        areaRepo.deleteById(areaId);
    }

    @Override
    public Area getAreaById(final Long id) {
        return areaRepo.findById(id)
                .orElseThrow();
    }

    @Override
    public List<Area> getAreas() {
        return areaRepo.findAll();
    }

    @Override
    public List<Area> getAreasByPlantation(final Long plantationId) {
        final var plantation = plantationRepo.findById(plantationId)
                .orElseThrow();
        return plantation.getSectors();
    }

    @Override
    public Plantation getPlantationById(final Long id) {
        return plantationRepo.findById(id)
                .orElseThrow();
    }

    @Override
    public List<Plantation> getPlantations() {
        return plantationRepo.findAll();
    }

    @Override
    public List<Plantation> getPlantationsByUser(final User user) {
        return plantationRepo.findByOwner(user)
                .orElseThrow();
    }

    @Override
    public void addEmployee(final Long plantationId, final Long userId) {
        final Plantation plantation = plantationRepo.findById(plantationId)
                .orElseThrow();
        final User employee = userRepo.findById(userId)
                .orElseThrow();
        if (employee.getPlantations()
                .contains(plantation) || plantation.getEmployees()
                .contains(employee)) {
            throw new RuntimeException("This user / worker has already assigned to this plantation");
        }
        employee.getPlantations()
                .add(plantation);
        plantation.getEmployees()
                .add(employee);
        plantationRepo.saveAndFlush(plantation);
    }

    @Override
    public List<User> getEmployees(final Long plantationId) {
        final var plantation = plantationRepo.findById(plantationId)
                .orElseThrow();
        return plantation.getEmployees();
    }

    @Override
    public List<Plantation> getUserWorkedInPlantations(final User user) {
        return plantationRepo.findPlantationsByEmployee(user.getId());
    }

    @Override
    public void deleteEmployeeFromPlantation(final User employee, final Plantation plantation) {
        employee.getPlantations()
                .remove(plantation);
        plantation.getEmployees()
                .remove(employee);
        userRepo.save(employee);
        plantationRepo.save(plantation);
    }

    private void assignPlantationData(PlantationRecord plantation, Plantation newPlantation) {
        newPlantation.setName(plantation.name());
        newPlantation.setNip(plantation.nip());
        newPlantation.setRegon(plantation.regon());
        newPlantation.setCity(plantation.city());
        newPlantation.setStreet(plantation.street());
        newPlantation.setHouseNumber(plantation.houseNumber());
        newPlantation.setFlatNumber(plantation.flatNumber());
        newPlantation.setPostCode(plantation.postCode());
        newPlantation.setSectors(PlantationMapper.INSTANCE.mapAreas(plantation.sectors()));
    }
}
