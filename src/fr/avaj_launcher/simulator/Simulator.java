package fr.avaj_launcher.simulator;

import fr.avaj_launcher.exception.*;
import fr.avaj_launcher.vehicule_base.Flyable;
import fr.avaj_launcher.vehicule_factory.AircraftFactory;
import fr.avaj_launcher.vehicule_observer.WeatherTower;

import java.io.IOException;

public class Simulator
{
	/*
		Attributes
	 */

	private Parser parser;
	private AircraftFactory af;
	private WeatherTower wt;
	private long cycle_nb;

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
			InvalidAircraftFormatException, IOException
	{
		AircraftParsingData data = new AircraftParsingData();
		Flyable vehicule;

		while (!data.endOfFile)
		{
			data = this.parser.parseAircraft();
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
