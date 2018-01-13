package fr.avaj_launcher.simulator;

import fr.avaj_launcher.vehicule.Coordinates;

public class AircraftParsingData
{
	/*
		Attributes
	 */

	public String aircraftType;
	public String aircraftName;
	public Coordinates coordinates;
	public boolean endOfFile;

	/*
		Constructor
	 */

	public AircraftParsingData()
	{
		this.endOfFile = false;
	}
}
