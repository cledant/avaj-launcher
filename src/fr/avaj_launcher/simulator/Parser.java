package fr.avaj_launcher.simulator;

import fr.avaj_launcher.exception.InvalidAircraftFormatException;
import fr.avaj_launcher.exception.InvalidCycleNumberException;
import fr.avaj_launcher.vehicule.Coordinates;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Parser
{
	/*
		Attributes
	 */

	private FileReader file;
	private BufferedReader br;

	/*
		Constructor
	 */

	public Parser(String fileName) throws FileNotFoundException
	{
		this.file = new FileReader(fileName);
		this.br = new BufferedReader(this.file);
	}

	/*
		Methods
	 */

	public long parseCycleNumber() throws InvalidCycleNumberException, IOException
	{
		String line = null;
		String[] split = null;

		if ((line = this.br.readLine()) == null)
			throw new InvalidCycleNumberException();
		split = line.split("\\s");
		if (split.length != 1)
			throw new InvalidCycleNumberException();
		try
		{
			return (Long.valueOf(split[0]));
		}
		catch (Exception e)
		{
			throw new InvalidCycleNumberException();
		}
	}

	public AircraftParsingData parseAircraft() throws InvalidAircraftFormatException, IOException
	{
		String line = null;
		String[] split = null;
		AircraftParsingData data = new AircraftParsingData();

		if ((line = this.br.readLine()) == null)
		{
			data.endOfFile = true;
			return (data);
		}
		split = line.split("\\s");
		if (split.length != 5)
			throw new InvalidAircraftFormatException();
		data.aircraftType = split[0];
		data.aircraftName = split[1];
		try
		{
			data.coordinates = new Coordinates(Integer.valueOf(split[2]), Integer.valueOf(split[3]),
					Integer.valueOf(split[4]));
			return (data);
		}
		catch (Exception e)
		{
			throw new InvalidAircraftFormatException();
		}
	}
}
