package fr.avaj_launcher.simulator;

import fr.avaj_launcher.exception.InvalidCycleNumberException;

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

	public AircraftParsingData parseAircraft()
	{
		//do again other things
		return (new AircraftParsingData());
	}
}
