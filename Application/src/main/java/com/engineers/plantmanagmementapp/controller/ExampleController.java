package com.engineers.plantmanagmementapp.controller;

import com.engineers.plantmanagmementapp.handler.ExampleHandler;
import com.engineers.plantmanagmementapp.rest.example.specification.api.ExampleApi;
import com.engineers.plantmanagmementapp.rest.example.specification.model.CarDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ExampleController implements ExampleApi {

    private final ExampleHandler exampleHandler;

    @Override
    public ResponseEntity<List<CarDto>> getCars() {
        return ResponseEntity.ok(exampleHandler.handleGetCars());
    }
}
