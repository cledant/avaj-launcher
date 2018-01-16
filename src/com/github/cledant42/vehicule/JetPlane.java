package com.github.cledant42.vehicule;

import com.github.cledant42.exception.*;
import com.github.cledant42.logger.Logger;
import com.github.cledant42.vehicule_observer.WeatherTower;

import java.io.IOException;

public class JetPlane extends Aircraft implements Flyable
{
	/*
		Attributes
	 */

	private WeatherTower weatherTower = null;
	String identifier;

	/*
		Constructor
	 */

	public JetPlane(String name, Coordinates coordinates) throws TooMuchAircraftException, InvalidAircraftHeightException,
			InvalidAircraftLatitudeException, InvalidAircraftLongitudeException
	{
		super(name, coordinates);
		this.identifier = "JetPlane#" + this.name + "(" + String.valueOf(this.id) + ")";
	}

	/*
		Methods
	 */

	@Override
	public void registerTower(WeatherTower weatherTower) throws IOException
	{
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Logger.getLogger().printMessage("Tower says : " + this.identifier + " registered to Weather Tower");
	}

	@Override
	public void updateConditions() throws IOException, UnknownWeatherException, UnregisteredTowerException
	{
		if (this.weatherTower == null)
			throw new UnregisteredTowerException();
		String weather = this.weatherTower.getWeather(this.coordinates);
		if (weather.compareTo("SUN") == 0)
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
			Logger.getLogger().printMessage(this.identifier + ": SUN - I'm melting !");
		}
		else if (weather.compareTo("RAIN") == 0)
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 5, this.coordinates.getHeight());
			Logger.getLogger().printMessage(this.identifier + ": RAIN - Wetter than water");
		}
		else if (weather.compareTo("FOG") == 0)
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + 1, this.coordinates.getHeight());
			Logger.getLogger().printMessage(this.identifier + ": FOG - Kero kero !");
		}
		else if (weather.compareTo("SNOW") == 0)
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
			Logger.getLogger().printMessage(this.identifier + ": SNOW - My name is John");
		}
		else
			throw new UnknownWeatherException();
		if (this.coordinates.getHeight() > 100)
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(),
					100);
		else if (this.coordinates.getLatitude() < 0)
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude() + Integer.MAX_VALUE, this.coordinates.getHeight());
		else if (this.coordinates.getLongitude() < 0)
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + Integer.MAX_VALUE,
					this.coordinates.getLatitude(), this.coordinates.getHeight());
		if (this.coordinates.getHeight() <= 0)
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 0);
			Logger.getLogger().printMessage("Tower says : " + this.identifier + " unregistered from Weather Tower");
			Logger.getLogger().printMessage(this.identifier + " : Landing coordinate = " + this.coordinates.getLongitude() +
					" " + this.coordinates.getLatitude() + " " + this.coordinates.getHeight());
			this.weatherTower.unregister(this);
		}
	}
}
