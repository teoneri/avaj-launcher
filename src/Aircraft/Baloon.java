package Aircraft;

import Main.WeatherTower;

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
		
		String weather = tower.getWeather(this.coordinates);

		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2,  this.coordinates.getLatitude(), this.coordinates.getHeight() + 4);
				System.out.println("Baloon#"  + this.name +"(" + this.id + "): Great weather today let's enjoy the view from up here.");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() - 5);
				System.out.println("Baloon#"  + this.name + "(" + this.id + "): Looks like we're getting a little wet good thing I don't need an engine.");
				break;
			case "FOG":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() - 3);
				System.out.println("Baloon#"  + this.name + "(" + this.id + "): Hard to see where I'm going, but at least it’s quiet up here.");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(this.coordinates.getLongitude(),  this.coordinates.getLatitude(), this.coordinates.getHeight() - 15);
				System.out.println("Baloon#"  + this.name + "(" + this.id + "): Light snow—makes for a peaceful flight, but it’s getting chilly.");
				break;
			default:
				break;
		}
	}
	public void registerTower(WeatherTower p_Tower)
	{
		this.tower = p_Tower;
		tower.register(this);
		System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") has successfuly registered to weather tower.");
	}

	public void unregisterTower()
	{
		tower.unregister(this);
		System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") has successfuly landed");
	}
}
