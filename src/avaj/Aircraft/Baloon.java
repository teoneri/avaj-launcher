package avaj.Aircraft;

import avaj.*;

public class Baloon extends Aircraft{	
	
	private WeatherTower tower;

	public Baloon(long p_id, String p_name, Coordinates p_coordinates){
		super(p_id, p_name, p_coordinates);
	}
	public void updateConditions()
	{

		if(this.coordinates.getHeight() <= 0)
		{
			unregisterTower();
			return;
		}
		else if(this.coordinates.getHeight() > 100)
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10,  this.coordinates.getLatitude(), 100);
		}
		
		String weather = tower.getWeather(this.coordinates);

		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2,  this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
				Logger.logMessage("Baloon#"  + this.name +"(" + this.id + "): Great weather today let's enjoy the view from up here.\n");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
				Logger.logMessage("Baloon#"  + this.name + "(" + this.id + "): Looks like we're getting a little wet good thing I don't need an engine.\n");
				break;
			case "FOG":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
				Logger.logMessage("Baloon#"  + this.name + "(" + this.id + "): Hard to see where I'm going, but at least it’s quiet up here.\n");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
				Logger.logMessage("Baloon#"  + this.name + "(" + this.id + "): Light snow—makes for a peaceful flight, but it’s getting chilly.\n");
				break;
			default:
				break;
		}
	}
	public void registerTower(WeatherTower p_Tower)
	{
		this.tower = p_Tower;
		tower.register(this);
		Logger.logMessage("Tower says: Baloon#" + this.name + "(" + this.id + ") has successfuly registered to weather tower.\n");
	}

	public void unregisterTower()
	{
		tower.unregister(this);
		Logger.logMessage("Tower says: Baloon#" + this.name + "(" + this.id + ") has successfuly landed,\n");
	}
}
