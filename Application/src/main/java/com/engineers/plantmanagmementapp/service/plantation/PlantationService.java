package com.engineers.plantmanagmementapp.service.plantation;

import com.engineers.plantmanagmementapp.model.Plantation;
import com.engineers.plantmanagmementapp.model.User;
import com.engineers.plantmanagmementapp.record.PlantationRecord;

public interface PlantationService {

    Plantation createPlantation(final PlantationRecord plantation, final User user);
}
