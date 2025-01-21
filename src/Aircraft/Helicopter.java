package Aircraft;

import Main.WeatherTower;

public class Helicopter extends Aircraft {

	WeatherTower tower;

	public Helicopter(long p_id, String p_name, Coordinates p_coordinates){
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
				System.out.println(this.name + "#" + this.id + "(" + unique_id + "): What a beautiful day for a spin! Let’s hover over the city and enjoy the view!\n");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() + 5);
				System.out.println(this.name + "#" + this.id + "(" + unique_id + "): Rain, rain, go away… or at least don’t mess up my blades too much!\n");
				break;
			case "FOG":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() + 1);
				System.out.println(this.name + "#" + this.id + "(" + unique_id + "): Visibility zero? Good thing I’m a pro at hovering in the unknown!\n");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
				System.out.println(this.name + "#" + this.id + "(" + unique_id + "): Blades spinning, snow flying—winter wonderland, here I come!\n");
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

