package Aircraft;

import Main.WeatherTower;

public class JetPlane extends Aircraft{

	WeatherTower tower;

	public JetPlane(long p_id, String p_name, Coordinates p_coordinates){
		super(p_id, p_name, p_coordinates);
	}

	public void updateConditions()
	{
		String weather = tower.getWeather(this.coordinates);

		if(this.coordinates.getHeight() <= 0)
		{
			unregisterTower();
			return;
		}
		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10,  this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
				System.out.println(this.name + "#" + this.id + "(" + unique_id + "): Clear skies and full speed ahead! Let’s break some records today!\n");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() + 5);
				System.out.println(this.name + "#" + this.id + "(" + unique_id + "): A little rain can’t slow me down, but I could use a windshield wiper!\n");
				break;
			case "FOG":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() + 1);
				System.out.println(this.name + "#" + this.id + "(" + unique_id + "): Fog? No problem. I’ve got instruments and the need for speed!\n");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
				System.out.println(this.name + "#" + this.id + "(" + unique_id + "): I’m slicing through snowflakes like a hot knife through butter!\n");
				break;
			default:
				break;
		}
	}
	public void registerTower(WeatherTower p_Tower)
	{
		this.tower = p_Tower;
		tower.register(this);
		System.out.println("Tower says: " + this.name + "#" +this.id + "(" + unique_id + ") has successfuly registered to weather tower.");
	}

	public void unregisterTower()
	{
		tower.unregister(this);
		System.out.println("Tower says: " + this.name + "#" +this.id + "(" + unique_id + ") has successfuly landed");
	}
}

