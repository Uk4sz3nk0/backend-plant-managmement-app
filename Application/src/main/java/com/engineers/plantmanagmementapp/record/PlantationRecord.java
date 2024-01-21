package com.engineers.plantmanagmementapp.record;

import com.engineers.plantmanagmementapp.model.User;

import java.util.List;

public record PlantationRecord(Long id, String name, String nip, String regon, String city,
                               String street, Integer houseNumber, Integer flatNumber,
                               String postCode, AreaRecord area, List<AreaRecord> sectors,
                               User owner, List<User> employee) {


}
