package com.engineers.backendprojectapp.controller;

import com.engineers.backendprojectapp.handler.ExampleHandler;
import com.engineers.example.api.ExampleApi;
import com.engineers.example.model.CarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController implements ExampleApi {

    private final ExampleHandler exampleHandler;

    // TODO: Fix lombok and delete this constructor
    public ExampleController(final ExampleHandler exampleHandler) {
        this.exampleHandler = exampleHandler;
    }

    @Override
    public ResponseEntity<List<CarDto>> getCars() {
        return ResponseEntity.ok(exampleHandler.handleGetCars());
    }

    @Override
    public ResponseEntity<String> hello(final String name) {
        return ResponseEntity.ok(exampleHandler.handleHello(name));
    }
}
