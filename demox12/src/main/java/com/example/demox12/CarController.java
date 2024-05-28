package com.example.demox12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping("/create/")
    public CarEntity createCar(@RequestBody CarEntity car) {
        return carRepository.save(car);
    }

    @GetMapping("/getall/")
    public List<CarEntity> getAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public CarEntity getCarById(@PathVariable Long id) {
        Optional<CarEntity> carOptional = carRepository.findById(id);
        return carOptional.orElse(new CarEntity());
    }

    @PatchMapping("/update/{id}")
    public CarEntity updateCarType(@PathVariable Long id, @RequestParam String type) {
        if (!carRepository.existsById(id)) {
            return new CarEntity();
        }

        CarEntity car = carRepository.findById(id).get();
        car.setType(type);
        return carRepository.save(car);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCar(@PathVariable Long id) {
        if (!carRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Car not found");
        }
        carRepository.deleteById(id);
    }

    @DeleteMapping("/deleteall/")
    public void deleteAllCars() {
        carRepository.deleteAll();
    }
}
