package fr.avaj_launcher.vehicule;

import fr.avaj_launcher.exception.InvalidAircraftHeightException;
import fr.avaj_launcher.exception.InvalidAircraftLatitudeException;
import fr.avaj_launcher.exception.InvalidAircraftLongitudeException;
import fr.avaj_launcher.exception.TooMuchAircraftException;

public abstract class Aircraft
{
	/*
		Attributes
     */

	private static long idCounter = 0;

	protected long id;
	protected String name;
	protected Coordinates coordinates;

    /*
		Constructor
     */

	protected Aircraft(String name, Coordinates coordinates) throws TooMuchAircraftException, InvalidAircraftHeightException,
			InvalidAircraftLatitudeException, InvalidAircraftLongitudeException
	{
		if (coordinates.getHeight() <= 0 || coordinates.getHeight() > 100)
			throw new InvalidAircraftHeightException();
		if (coordinates.getLongitude() < 0)
			throw new InvalidAircraftLongitudeException();
		if (coordinates.getLatitude() < 0)
			throw new InvalidAircraftLatitudeException();
		this.coordinates = coordinates;
		this.name = name;
		this.id = Aircraft.nextId();
	}

    /*
		Methods
     */

	private static long nextId() throws TooMuchAircraftException
	{
		idCounter++;
		if (idCounter <= 0)
			throw new TooMuchAircraftException();
		return (idCounter);
	}
}
