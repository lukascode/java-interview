package com.lukascode.interview.interview;

import com.lukascode.interview.interview.dto.AddCarDto;
import com.lukascode.interview.interview.dto.CarDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class CarCrudServiceTest {

    private CarCrudService sut;

    @BeforeEach
    public void beforeEach() {
        sut = new CarCrudService();
    }

    @Test
    public void shouldAddCarProperly() {
        // given
        AddCarDto car = prepareCar();

        // when
        String carId = sut.addCar(car);

        // then
        Assertions.assertThat(carId).isNotEmpty();
        Assertions.assertThat(sut.getCar(carId)).isPresent();
    }

    @Test
    public void shouldGetAllCarsProperly() {
        // given
        sut.addCar(prepareCar());
        sut.addCar(prepareCar());
        sut.addCar(prepareCar());

        // when
        List<CarDto> cars = sut.getAllCars();

        // then
        Assertions.assertThat(cars).hasSize(3);
    }

    @Test
    public void shouldGetCarByNameProperly() {
        // given
        sut.addCar(prepareCar());

        // when
        Optional<CarDto> volvo = sut.getCarByName("Volvo");

        // then
        Assertions.assertThat(volvo).isPresent();
    }

    private AddCarDto prepareCar() {
        return new AddCarDto("Volvo", "RED", 1);
    }
}
