package com.example.cars;

import com.example.cars.Car;
import com.example.cars.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
public class CarService {
    
	@Autowired
	private CarRepository repository;
	
	public CarService(CarRepository repository) {
		this.repository = repository;
	}
	public Car create(Car cars) {
		return repository.save(cars);
	}
	public Optional<Car> get(Integer carId) {
		Optional<Car> optionalCar= repository.findById(carId);
		return optionalCar;
	}
	public List<Car> getAll() {
        List<Car> cars = null;
       // try {
            cars = repository.findAll();
        /*} catch (Exception e) {
            System.out.println("STackTrace: " + Arrays.toString(e.getStackTrace()));
            System.out.println("Caught an Exception....");
            cars = new ArrayList<>();
        }*/
        return cars;
    }
	public Car update(Integer CarId, Car cars) {
        if (CarId != cars.getCarId()) {
           // throw new CarValidationException("Mismatch in CarId");
        }
        Optional<Car> carsOptional = repository.findById(CarId);
        if (carsOptional.isPresent()) {
            return repository.save(cars);
        }
        else {
            //throw new CarNotFoundException("Car Not found: " + carId);
            return null;
        }
    }
}
