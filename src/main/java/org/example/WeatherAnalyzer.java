package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WeatherAnalyzer {

    /// This method reads data from a CSV file
    /// First line is treated as a header
    /// @param filepath filepath to CSV file
    /// @return list containing parsed weather data
    /// @throws IOException if the file cannot be read

    public static List<WeatherData> loadWeatherData(Path filepath)
            throws IOException {

        List<WeatherData> weatherData = new ArrayList<>();

        List<String> lines = Files.readAllLines(filepath);

        for (int i = 1; i < lines.size(); i++) {
            String[] values = lines.get(i).split(",");

            WeatherData day = new WeatherData(
                    values[0],
                    Double.parseDouble(values[1]),
                    Integer.parseInt(values[2]),
                    Double.parseDouble(values[3])
            );
            weatherData.add(day);
        }
        return weatherData;
    }

    /// Calculates Average Temperature  for specified month
    /// @param data the weather data to analyze
    /// @param month the month
    /// @return the average temperature or '0.0' if average cannot be calculated
    public static double calculateAverageTemperature(
            List<WeatherData> data, String month) {

        return data.stream()
                .filter(day -> day.date().startsWith(month))
                .mapToDouble(WeatherData::temperature)
                .average()
                .orElse(0.0);
    }

    /// Find days that exceeds the specified threshold temperature
    /// @param data the weather data to analyze
    /// @param threshold the threshold temperature
    /// @return list of days whcih the temperature exceeds threshold
    public static List<WeatherData> findHotDays (
            List<WeatherData> data, double threshold) {
        return data.stream()
                .filter(day -> day.temperature() > threshold)
                .toList();
    }

    /// Counts the number of days that has chance of rain
    /// @param data the weather data to analyze
    /// @return a counter result of how many days has chance of rain
    public static long countRainyDays(List<WeatherData> data) {
        return data.stream()
                .filter(day -> day.precipitation() > 0)
                .count();
    }

    /// Categorizes each day at "Hot", "Warm", or "Cold" depending on the temperature.
    /// @param temperature the temperature in Celsius
    /// @return the corresponding weather category
    public static String categorizeTemperature(double temperature) {

        return switch (temperature >= 30 ? "Hot" :
                                    temperature >= 20 ? "Warm" : "Cold") {
            case "Hot" -> "Hot";
            case "Warm" -> "Warm";
            default -> "Cold";
        };
    }

    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("src/main/resources/weatherdata.csv");

        List<WeatherData> data = loadWeatherData(filePath);

        String month = "2023-08";
        double threshold = 30.0;

        String heading = """
                ++++++++++++++++++++++++++++++++++++++++++++
                           WEATHER DATA ANALYZER
                ++++++++++++++++++++++++++++++++++++++++++++
                """;
        System.out.println(heading);
        double average = calculateAverageTemperature(data, month);
        System.out.println("\nAverage temperature for " + month + ": "
                + average + "°C");

        System.out.println("\nDays above " + threshold + "°C:");

        List<WeatherData> hotDays = findHotDays(data, threshold);
        hotDays.forEach(System.out::println);

        System.out.println("\nNumber of rainy days: "
                + countRainyDays(data));

        System.out.println("\nWeather categories:");

        data.forEach(day ->
                System.out.println(day.date() + ": "
                        + categorizeTemperature(day.temperature())));
    }
}
