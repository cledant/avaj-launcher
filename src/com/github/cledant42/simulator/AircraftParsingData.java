package com.github.cledant42.simulator;

import com.github.cledant42.vehicule.Coordinates;

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
