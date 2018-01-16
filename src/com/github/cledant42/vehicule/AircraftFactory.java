package com.github.cledant42.vehicule;

import com.github.cledant42.exception.*;

public class AircraftFactory
{
	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws UnknownAircraftTypeException,
			TooMuchAircraftException, InvalidAircraftHeightException, InvalidAircraftLongitudeException,
			InvalidAircraftLatitudeException
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
