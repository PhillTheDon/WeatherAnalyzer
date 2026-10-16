package org.example;

public record WeatherData (
    String date,
    double temperature,
    int humidity,
    double precipitation
) {}
