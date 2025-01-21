package Main;

public interface Flyable {
	WeatherTower WeatherTower = new WeatherTower();

	public abstract void updateConditions();
	void registerTower(WeatherTower p_tower);
}