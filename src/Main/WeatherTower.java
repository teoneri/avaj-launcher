package Main;

import Aircraft.Coordinates;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates p_Coordinates)
	{
		return WeatherProvider.getInstance().getCurrentWeather(p_Coordinates)
	}
	public void changeWeather()
	{
		this.conditionChanged();
	}
}
