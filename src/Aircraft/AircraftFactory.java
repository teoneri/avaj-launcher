package Aircraft;

import Main.Flyable;

public class AircraftFactory {
	static long idCounter = 1;

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
	{

		if(p_coordinates.getLatitude() < 0 || p_coordinates.getLatitude() < 0 || p_coordinates.getHeight() <= 0)
			throw new RuntimeException("Invalid coordinates");
		if(p_coordinates.getHeight() > 100)
			p_coordinates = new Coordinates(p_coordinates.getLongitude(), p_coordinates.getLatitude(), 100);
		switch (p_type.toLowerCase()) {
			case "helicopter":
				return new Helicopter(idCounter++, p_name, p_coordinates);
			case "baloon":
				return new Baloon(idCounter++, p_name, p_coordinates);
			case "jetplane":
				return new JetPlane(idCounter++, p_name, p_coordinates);
			default:
				throw new RuntimeException("Invalid aircraft type");
		}
		
	}
	
}
