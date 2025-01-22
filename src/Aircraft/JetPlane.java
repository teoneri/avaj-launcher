package Aircraft;

import Main.WeatherTower;

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

		String weather = tower.getWeather(this.coordinates);

		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10,  this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
				System.out.println("JetPlane" + this.name  + "(" + this.id + "): Clear skies and full speed ahead! Let’s break some records today!");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() + 5);
				System.out.println("JetPlane" + this.name  + "(" + this.id + "): A little rain can’t slow me down, but I could use a windshield wiper!");
				break;
			case "FOG":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() + 1);
				System.out.println("JetPlane" + this.name  + "(" + this.id + "): Fog? No problem. I’ve got instruments and the need for speed!");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
				System.out.println("JetPlane" + this.name  + "(" + this.id + "): I’m slicing through snowflakes like a hot knife through butter!");
				break;
			default:
				break;
		}
	}
	public void registerTower(WeatherTower p_Tower)
	{
		this.tower = p_Tower;
		tower.register(this);
		System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") has successfuly registered to weather tower.");
	}

	public void unregisterTower()
	{
		tower.unregister(this);
		System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") has successfuly landed");
	}
}

