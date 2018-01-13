package fr.avaj_launcher.vehicule;

import fr.avaj_launcher.exception.InvalidAircraftHeightException;
import fr.avaj_launcher.exception.TooMuchAircraftException;
import fr.avaj_launcher.exception.UnknownAircraftTypeException;

public class AircraftFactory
{
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws UnknownAircraftTypeException,
			TooMuchAircraftException, InvalidAircraftHeightException
	{
		Flyable tmp = null;

		if (type.compareTo("JetPlane") == 0)
			tmp = new JetPlane(name, new Coordinates(longitude, latitude, height));
		else if (type.compareTo("Baloon") == 0)
			tmp = new Baloon(name, new Coordinates(longitude, latitude, height));
		else if (type.compareTo("Helicopter") == 0)
			tmp = new Helicopter(name, new Coordinates(longitude, latitude, height));
		else
			throw new UnknownAircraftTypeException();
		return (tmp);
	}
}
