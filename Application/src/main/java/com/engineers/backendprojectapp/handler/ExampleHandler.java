package com.engineers.backendprojectapp.handler;

import com.engineers.example.model.CarDto;

import java.util.List;

public interface ExampleHandler {

    String handleHello(final String name);

    List<CarDto> handleGetCars();
}
