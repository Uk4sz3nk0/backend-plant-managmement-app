package com.engineers.backendprojectapp.handler.mock;

import com.engineers.backendprojectapp.handler.ExampleHandler;
import com.engineers.example.model.CarDto;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary // Adnotacja mówiąca który handler jest aktualnie używany
public class ExampleHandlerMock implements ExampleHandler {

    @Override
    public String handleHello(final String name) {
        return "Hello " + name;
    }

    @Override
    public List<CarDto> handleGetCars() {
        return List.of(
                generateCar(1L, "Volkswagen", 2008),
                generateCar(2L, "Peugeot", 2013),
                generateCar(3L, "Volvo", 2023)
        );
    }

    private CarDto generateCar(final Long id, final String name, final Integer productionYear) {
        final CarDto car = new CarDto();
        car.setId(id);
        car.setName(name);
        car.setProductionYear(productionYear);
        return car;
    }
}
