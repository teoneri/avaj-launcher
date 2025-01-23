package avaj;

import avaj.Aircraft.Coordinates;

public class WeatherProvider {
    private static WeatherProvider instance = null;
    private String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return weather[(coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % weather.length];
    }
}