package com.lukascode.interview.interview.dto;

public class CarDto {

    private String name;

    private String color;

    private int version;

    public CarDto(String name, String color, int version) {
        this.name = name;
        this.color = color;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getVersion() {
        return version;
    }
}
