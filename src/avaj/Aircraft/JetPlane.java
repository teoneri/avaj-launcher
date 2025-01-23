package avaj.Aircraft;

import avaj.*;

public class JetPlane extends Aircraft{

	WeatherTower tower;

	public JetPlane(long p_id, String p_name, Coordinates p_coordinates){
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
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10,  this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
				Logger.logMessage("JetPlane" + this.name  + "(" + this.id + "): Clear skies and full speed ahead! Let’s break some records today!\n");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() + 5);
				Logger.logMessage("JetPlane" + this.name  + "(" + this.id + "): A little rain can’t slow me down, but I could use a windshield wiper!\n");
				break;
			case "FOG":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() + 1);
				Logger.logMessage("JetPlane" + this.name  + "(" + this.id + "): Fog? No problem. I’ve got instruments and the need for speed!\n");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
				Logger.logMessage("JetPlane" + this.name  + "(" + this.id + "): I’m slicing through snowflakes like a hot knife through butter!\n");
				break;
			default:
				break;
		}
	}
	public void registerTower(WeatherTower p_Tower)
	{
		this.tower = p_Tower;
		tower.register(this);
		Logger.logMessage("Tower says: JetPlane#" + this.name + "(" + this.id + ") has successfuly registered to weather tower.\n");
	}

	public void unregisterTower()
	{
		tower.unregister(this);
		Logger.logMessage("Tower says: JetPlane#" + this.name + "(" + this.id + ") has successfuly landed.\n");
	}
}

