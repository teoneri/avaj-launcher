package Aircraft;

import Main.WeatherTower;

public class Helicopter extends Aircraft {

	WeatherTower tower;

	public Helicopter(long p_id, String p_name, Coordinates p_coordinates){
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
				System.out.println("Helicopter#" + this.name + "(" + this.id + "): What a beautiful day for a spin! Let’s hover over the city and enjoy the view!");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() + 5);
				System.out.println("Helicopter#" + this.name + "(" + this.id + "): Rain, rain, go away… or at least don’t mess up my blades too much!");
				break;
			case "FOG":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() + 1);
				System.out.println("Helicopter#" + this.name + "(" + this.id + "): Visibility zero? Good thing I’m a pro at hovering in the unknown!");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
				System.out.println("Helicopter#" + this.name + "(" + this.id + "): Blades spinning, snow flying—winter wonderland, here I come!");
				break;
			default:
				break;
		}
	}

	public void registerTower(WeatherTower p_Tower)
	{
		this.tower = p_Tower;
		tower.register(this);
		System.out.println("Tower says: Helicopter#" + this.name  + "(" + this.id + ") has successfuly registered to weather tower.");
	}

	public void unregisterTower()
	{
		tower.unregister(this);
		System.out.println("Tower says: Helicopter#" + this.name  + "(" + this.id + ") has successfuly landed");
	}
}

