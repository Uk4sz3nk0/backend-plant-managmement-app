package com.engineers.plantmanagmementapp.record;

import java.util.List;

public record AreaRecord(Long id, String name, String polygonColor, List<CoordinateRecord> coordinates, Boolean isMainArea) {
}
