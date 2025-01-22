package Aircraft;

import Main.Flyable;

public abstract class Aircraft implements Flyable{
	protected long id;
	protected String name;
	protected Coordinates coordinates;

	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates)
	{
		this.id = p_id;
		this.name = p_name;
		if(p_coordinates.getHeight() <= 0 || p_coordinates.getLatitude() < 0|| p_coordinates.getLatitude() < 0)
			throw new RuntimeException("Coordinates error\n");
		this.coordinates = p_coordinates;
	}

}
