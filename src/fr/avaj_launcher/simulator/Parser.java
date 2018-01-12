package fr.avaj_launcher.simulator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

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

	public long parseCycleNumber()
	{
		//do things too
		return (0);
	}

	public AircraftParsingData parseAircraft()
	{
		//do again other things
		return (new AircraftParsingData());
	}
}
