package com.engineers.plantmanagmementapp.handler;

import com.engineers.plantmanagmementapp.rest.example.specification.model.CarDto;

import java.util.List;

public interface ExampleHandler {

    List<CarDto> handleGetCars();
}
