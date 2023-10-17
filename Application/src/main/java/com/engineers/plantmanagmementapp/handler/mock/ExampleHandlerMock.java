package com.engineers.plantmanagmementapp.handler.mock;

import com.engineers.plantmanagmementapp.handler.ExampleHandler;
import com.engineers.plantmanagmementapp.rest.example.specification.model.CarDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExampleHandlerMock implements ExampleHandler {

    @Override
    public List<CarDto> handleGetCars() {
        return List.of(
                generateCar(1L, "Volkswagen", "Golf"),
                generateCar(2L, "BMW", "Series 5"),
                generateCar(3L, "Renault", "Megane"),
                generateCar(4L, "Seat", "Leon")
        );
    }

    private CarDto generateCar(final Long id, final String manufacture, final String model) {
        final CarDto car = new CarDto();
        car.setId(id);
        car.setManufacture(manufacture);
        car.setModel(model);
        return car;
    }
}
