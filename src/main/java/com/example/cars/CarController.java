package com.example.cars;

import com.example.cars.Car;
import com.example.cars.CarService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/cars")
@RestController
public class CarController {

	private CarService service;

    public CarController(CarService service) {
        this.service = service;
    }
    
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Car> getCar(@PathVariable("id") Integer CarId) {
        return service.get(CarId);
    }
    
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Car updateCar(@PathVariable("id") Integer CarId, @RequestBody Car cars) {
        return service.update(CarId, cars);
    }
    
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> getAll() {
        return service.getAll();
    }
    
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Car createCar(@RequestBody Car cars) {
        Car createdCar = service.create(cars);
        return createdCar;
    }
    
}
