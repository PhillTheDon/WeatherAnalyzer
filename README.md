# 🌦️ Weather Data Analyzer

## 📌 Project Overview

The Weather Data Analyzer is a Java application that reads weather data from a CSV file and analyzes temperature and precipitation information.

The application uses modern Java features to calculate average temperatures, identify days above a specified temperature threshold, count rainy days, and categorize daily weather conditions.

## ✨ Features

- **CSV File Processing:** Reads weather records from a CSV file.
- **Average Temperature:** Calculates the average temperature for a specified month.
- **Hot Day Detection:** Identifies days when the temperature exceeds a specified threshold.
- **Rainy Day Counter:** Counts days with recorded precipitation greater than zero.
- **Temperature Categorization:** Classifies temperatures as Hot, Warm, or Cold.
- **Modern Java Features:** Uses records, lambda expressions, Stream API operations, switch expressions, and text blocks.
- **Javadoc Documentation:** Uses modern documentation comments to describe methods and their parameters.

## 🛠️ Technologies Used

- Java 25
- Maven project structure
- IntelliJ IDEA
- CSV data processing
- Java Stream API
- Lambda expressions
- Java records

## 📂 Project Structure

```text
WeatherDataAnalyzer/
├── src/
│   └── main/
│       ├── java/
│       │   └── org/
│       │       └── example/
│       │           ├── WeatherAnalyzer.java
│       │           └── WeatherData.java
│       └── resources/
│           └── weatherdata.csv
└── README.md
```

## 📊 CSV Data Format

The application reads weather information from `weatherdata.csv`.

The CSV file uses the following columns:

| Column | Description |
|---|---|
| Date | Date of the weather observation |
| Temperature | Recorded temperature in Celsius |
| Humidity | Relative humidity percentage |
| Precipitation | Recorded precipitation amount |

Example:

```csv
Date,Temperature,Humidity,Precipitation
2023-08-01,32.5,65,0.0
2023-08-02,35.0,60,0.2
2023-08-03,28.0,70,1.5
```

## ⚙️ How It Works

### 1. Load Weather Data
The application reads the CSV file, skips the header row, and converts each record into a `WeatherData` object.

### 2. Calculate Average Temperature
The Stream API filters records for the specified month and calculates the average temperature.

### 3. Find Hot Days
The application filters weather records to find days when the temperature exceeds the configured threshold.

### 4. Count Rainy Days
The application counts records where precipitation is greater than zero.

### 5. Categorize Temperatures
Each day's temperature is classified into one of three categories:

- **Hot:** 30°C or higher
- **Warm:** 20°C or higher but below 30°C
- **Cold:** Below 20°C

## ▶️ How to Run

1. Open the project in IntelliJ IDEA.
2. Make sure JDK 25 is configured.
3. Open `WeatherAnalyzer.java`.
4. Run the `main()` method.
5. Review the analysis results in the Run console.

Make sure `weatherdata.csv` is located at:

`src/main/resources/weatherdata.csv`

## 🧪 Example Results

Using the included sample dataset, the application produces results similar to:

```text
Average temperature for 2023-08: 27.2°C

Days above 30.0°C:
WeatherData[date=2023-08-01, temperature=32.5, humidity=65, precipitation=0.0]
WeatherData[date=2023-08-02, temperature=35.0, humidity=60, precipitation=0.2]
WeatherData[date=2023-09-02, temperature=31.0, humidity=68, precipitation=0.5]

Number of rainy days: 4

Weather categories:
2023-08-01: Hot
2023-08-02: Hot
2023-08-03: Warm
2023-08-04: Warm
2023-08-05: Cold
2023-09-01: Warm
2023-09-02: Hot
2023-09-03: Cold
```

## 🎯 Learning Objectives

This project demonstrates the use of modern Java programming concepts, including:

- Records for representing structured weather data.
- Lambda expressions for defining concise operations.
- Stream API methods such as `filter()`, `mapToDouble()`, `average()`, and `count()`.
- Switch expressions for returning values based on conditions.
- Text blocks for formatting multiline strings.
- File I/O for reading CSV data.
- Javadoc comments for documenting methods.

## 👨‍💻 Author

Developed as a Java programming project to practice modern Java language features and functional programming concepts.

## ‼️ ACKNOWLEDGMENT

THIS README WAS DEVELOPED USING CHATGPT AS A LEARNING TEMPLATE.