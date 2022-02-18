package de.ewertw.costtrackingbe.controller.testing;

import de.ewertw.costtrackingbe.models.testing.Car;
import de.ewertw.costtrackingbe.services.testing.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/testing/car")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping
    public List<Car> getAllCars(){
        return carService.getCars();
    }
}
