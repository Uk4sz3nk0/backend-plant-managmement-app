package com.engineers.plantmanagmementapp.service.plantation.impl;

import com.engineers.plantmanagmementapp.model.Plantation;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.record.PlantationRecord;
import com.engineers.plantmanagmementapp.repository.PlantationRepository;
import com.engineers.plantmanagmementapp.service.plantation.PlantationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlantationServiceImpl implements PlantationService {

    private final PlantationRepository plantationRepo;

    @Override
    public Plantation createPlantation(final PlantationRecord plantationRecord, final User user) {
        final Plantation plantation = new Plantation();
        plantation.setName(plantationRecord.name());
        plantation.setNip(plantationRecord.nip());
        plantation.setRegon(plantationRecord.regon());
        plantation.setCity(plantationRecord.city());
        plantation.setStreet(plantationRecord.street());
        plantation.setHouseNumber(plantationRecord.houseNumber());
        plantation.setFlatNumber(plantationRecord.flatNumber());
        plantation.setPostCode(plantationRecord.postCode());
        plantation.setOwner(user);
        return plantationRepo.save(plantation);
    }
}
