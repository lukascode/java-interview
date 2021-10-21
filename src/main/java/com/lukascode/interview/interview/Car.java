package com.lukascode.interview.interview;

public class Car {

    private String name;

    private CarColor color;

    private int version;

    public Car(String name, CarColor color, int version) {
        if (version <= 0) {
            throw new IllegalArgumentException("Version should be greater than 0");
        }
        this.version = version;
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public CarColor getColor() {
        return color;
    }

    public int getVersion() {
        return version;
    }
}
