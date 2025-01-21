package Aircraft;

import Main.Flyable;

public class AircraftFactory {

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
	{
		try
		{
			if(p_coordinates.getLatitude() < 0 || p_coordinates.getLatitude() < 0 || p_coordinates.getHeight() <= 0)
				throw new RuntimeException();
			if(p_coordinates.getHeight() > 100)
				p_coordinates = new Coordinates(p_coordinates.getLongitude(), p_coordinates.getLatitude(), 100);
			switch (p_type) {
				case "Helicopter":
					System.out.println("New helicopter created.\n");
					return new Helicopter()
					break;
			
				default:
					break;
			}
		}
	}
	
}
