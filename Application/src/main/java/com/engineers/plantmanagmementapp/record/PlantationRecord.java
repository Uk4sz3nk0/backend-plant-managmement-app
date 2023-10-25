package com.engineers.plantmanagmementapp.record;

public record PlantationRecord(String name, String nip, String regon, String city, String street, Integer houseNumber,
                               Integer flatNumber, String postCode) {
}
