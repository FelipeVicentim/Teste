package com.wsteste.atividade01.resources;

import com.wsteste.atividade01.model.Cars;
import com.wsteste.atividade01.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CarsResource {

    @Autowired
    private CarsRepository carsRepository;

    @GetMapping("/cars")
    public List<Cars> listCars(){
        return carsRepository.findAll();
    }

    @GetMapping("/car/{id}")
    public Cars carsById(@PathVariable(value = "id")long id){
        return carsRepository.findById(id);
    }

    @PostMapping("/car")
    public Cars saveCar(@RequestBody Cars car){
        return carsRepository.save(car);
    }

    @DeleteMapping("/car")
    public void deleteCar(@RequestBody Cars car){
        carsRepository.delete(car);
    }

    @PutMapping("/car")
    public Cars putCar(@RequestBody Cars car){
        return carsRepository.save(car);
    }
}
