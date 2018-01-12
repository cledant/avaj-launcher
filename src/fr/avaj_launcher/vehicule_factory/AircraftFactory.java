package fr.avaj_launcher.vehicule_factory;

import fr.avaj_launcher.exception.InvalidAircraftHeightException;
import fr.avaj_launcher.exception.TooMuchAircraftException;
import fr.avaj_launcher.exception.UnknownAircraftTypeException;
import fr.avaj_launcher.vehicule_base.Coordinates;
import fr.avaj_launcher.vehicule_base.Flyable;
import fr.avaj_launcher.vehicule_specialized.JetPlane;
import fr.avaj_launcher.vehicule_specialized.Baloon;
import fr.avaj_launcher.vehicule_specialized.Helicopter;

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
