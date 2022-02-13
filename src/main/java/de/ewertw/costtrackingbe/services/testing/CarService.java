package de.ewertw.costtrackingbe.services.testing;

import de.ewertw.costtrackingbe.models.testing.Car;
import de.ewertw.costtrackingbe.repositories.testing.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> getCars(){
        return carRepository.findAll();
    }
}
