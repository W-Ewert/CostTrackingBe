package de.ewertw.costtrackingbe.controllers.testing;

import de.ewertw.costtrackingbe.models.testing.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/testing/car")
public class CarController {

    @GetMapping
    public List<Car> getCars(){
        return List.of(
                new Car("Audi", "A6")
        );
    }
}
