package com.github.cledant42.simulator;

import com.github.cledant42.exception.*;
import com.github.cledant42.vehicule.AircraftFactory;
import com.github.cledant42.vehicule_observer.WeatherTower;
import com.github.cledant42.vehicule.Flyable;

import java.io.IOException;

public class Simulator
{
	/*
		Attributes
	 */

	private Parser parser;
	private AircraftFactory af;
	private WeatherTower wt;
	private int cycle_nb;

	/*
		Constructor
	 */

	public Simulator(String fileName) throws IOException
	{
		parser = new Parser(fileName);
		af = new AircraftFactory();
		wt = new WeatherTower();
	}

	/*
		Methods
	 */

	public void parseCycleNumber() throws IOException, InvalidCycleNumberException
	{
		this.cycle_nb = parser.parseCycleNumber();
		if (this.cycle_nb <= 0)
			throw new InvalidCycleNumberException();
	}

	public void parseAircraft() throws TooMuchAircraftException, UnknownAircraftTypeException, InvalidAircraftHeightException,
			InvalidAircraftLatitudeException, InvalidAircraftLongitudeException, InvalidAircraftFormatException, IOException
	{
		AircraftParsingData data = new AircraftParsingData();
		Flyable vehicule;

		while (true)
		{
			data = this.parser.parseAircraft();
			if (data.endOfFile)
				break;
			vehicule = this.af.newAircraft(data.aircraftType, data.aircraftName, data.coordinates.getLongitude(),
					data.coordinates.getLatitude(), data.coordinates.getHeight());
			vehicule.registerTower(this.wt);
		}
	}

	public void simulate() throws UnknownWeatherException, UnregisteredTowerException, UnknownAircraftTypeException,
			IOException
	{
		for (long i = this.cycle_nb; i > 0; i--)
			this.wt.changeWeather();
	}
}
