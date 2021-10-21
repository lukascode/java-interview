package com.lukascode.interview.interview;

import com.lukascode.interview.interview.dto.AddCarDto;
import com.lukascode.interview.interview.dto.CarDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarCrudService carCrudService;

    public CarController(CarCrudService carCrudService) {
        this.carCrudService = carCrudService;
    }

    @PostMapping
    public String addCar(@RequestBody AddCarDto addCarDto) {
        return carCrudService.addCar(addCarDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable String id) {
        return carCrudService.getCar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarDto> cars = carCrudService.getAllCars();
        if (cars.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/search")
    public ResponseEntity<CarDto> searchCar(@RequestParam String name) {
        return carCrudService.getCarByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
