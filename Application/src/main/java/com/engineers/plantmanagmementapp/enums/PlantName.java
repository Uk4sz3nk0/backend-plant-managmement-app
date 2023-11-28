package com.engineers.plantmanagmementapp.enums;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
public enum PlantName {

    BLUEBERRY("Borówka"),
    STRAWBERRY("Truskawka"),
    APPLE("Jabłko"),
    RASPBERRY("Malina");

    private String name;
}
