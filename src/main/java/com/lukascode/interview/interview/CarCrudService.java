package com.lukascode.interview.interview;

import com.lukascode.interview.interview.dto.AddCarDto;
import com.lukascode.interview.interview.dto.CarDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CarCrudService {

    private final Map<String, Car> carRepository = new HashMap<>();

    public String addCar(AddCarDto addCarDto) {
        Car car = new Car(
                addCarDto.getName(),
                CarColor.valueOf(addCarDto.getColor()),
                addCarDto.getVersion()
        );
        String carId = UUID.randomUUID().toString();
        carRepository.put(carId, car);
        return carId;
    }

    public Optional<CarDto> getCar(String carId) {
        return Optional.ofNullable(carRepository.get(carId))
                .map(this::convertToDto);
    }

    public Optional<CarDto> getCarByName(String name) {
        return getAllCars().stream()
                .filter(car -> car.getName().equals(name))
                .findAny();
    }

    public List<CarDto> getAllCars() {
        return carRepository.entrySet().stream()
                .map(Map.Entry::getValue)
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CarDto convertToDto(Car car) {
        return new CarDto(car.getName(), car.getColor().name(), car.getVersion());
    }
}
