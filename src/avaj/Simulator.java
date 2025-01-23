package avaj;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import avaj.Aircraft.AircraftFactory;
import avaj.Aircraft.Coordinates;


public class Simulator{

	private static BufferedReader reader;
	private static int simCount;
	private static WeatherTower tower;
	private static AircraftFactory aircraftFactory;
	


	private static void parseScenario(List<String> lines)
	{
		try{
			simCount = Integer.parseInt(lines.get(0));
			if(simCount < 0)
				throw new RuntimeException("Invalid sim cycle #");
			tower = new WeatherTower();
			aircraftFactory = new AircraftFactory();
			for(int i = 1; i < lines.size(); i++)
			{
				String[] indString =  lines.get(i).split(" ");
				if(indString.length != 5)
					throw new RuntimeException("Invalid aircraft specification");
				if(!indString[0].toLowerCase().contentEquals("helicopter") && !indString[0].toLowerCase().contentEquals("jetplane") && 
					!indString[0].toLowerCase().contentEquals("baloon"))
					throw new RuntimeException("Invalid aircraft specification");
				for(int j = 2; j < 5; j++)
				{
					int num = Integer.parseInt(indString[2]);
					if(num < 0)
						throw new RuntimeException("Invalid coordinate specification");
				}
				Coordinates coordinates = aircraftFactory.initCoordinates(Integer.parseInt(indString[2]), Integer.parseInt(indString[3]), Integer.parseInt(indString[4]));
				aircraftFactory.newAircraft(indString[0], indString[1], coordinates).registerTower(tower);
			}
		}
		catch(NumberFormatException e)
		{
			throw new RuntimeException("Invalid integer.");
		}
	}

	private static void readFile(String fileName)
	{
		try
		{
			reader = new BufferedReader(new FileReader(fileName));
			List<String> lines = new ArrayList<String>();
			String tmp;
			for(int i = 0; (tmp = reader.readLine()) != null; i++)
				lines.add(i, tmp);
			reader.close();
			if(lines.size() == 0)
				throw new IOException();
			parseScenario(lines);
		}
		catch(IOException e)
		{
			System.err.println("File read error");
		}
	}


	public static void main(String[] args){
		try
		{
			if(args.length != 1)
			{
				throw new IllegalArgumentException("Invalid # of arguments");
			}
			readFile(args[0]);
			while(--simCount >= 0)
			{
				tower.changeWeather();
			}
			Logger.printSim();
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}
}
}