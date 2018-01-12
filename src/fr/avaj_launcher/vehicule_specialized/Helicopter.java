package fr.avaj_launcher.vehicule_specialized;

import fr.avaj_launcher.exception.TooMuchAircraftException;
import fr.avaj_launcher.exception.UnknownWeatherException;
import fr.avaj_launcher.exception.UnregisteredTowerException;
import fr.avaj_launcher.logger.Logger;
import fr.avaj_launcher.vehicule_base.Aircraft;
import fr.avaj_launcher.vehicule_base.Coordinates;
import fr.avaj_launcher.vehicule_base.Flyable;
import fr.avaj_launcher.vehicule_observer.WeatherTower;

import java.io.IOException;

public class Helicopter extends Aircraft implements Flyable
{
	/*
		Attributes
	 */

	private WeatherTower weatherTower = null;
	String identifier;

	/*
		Constructor
	 */

	public Helicopter(String name, Coordinates coordinates) throws TooMuchAircraftException
	{
		super(name, coordinates);
		this.identifier = "Helicopter#" + this.name + "(" + String.valueOf(this.id) + ")";
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
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10,
					this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
			Logger.getLogger().printMessage(this.identifier + ": SUN");
		}
		else if (weather.compareTo("RAIN") == 0)
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5,
					this.coordinates.getLatitude(), this.coordinates.getHeight());
			Logger.getLogger().printMessage(this.identifier + ": RAIN");
		}
		else if (weather.compareTo("FOG") == 0)
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1,
					this.coordinates.getLatitude(), this.coordinates.getHeight());
			Logger.getLogger().printMessage(this.identifier + ": FOG");
		}
		else if (weather.compareTo("SNOW") == 0)
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude(),
					this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
			Logger.getLogger().printMessage(this.identifier + ": SNOW");
		}
		else
			throw new UnknownWeatherException();
		if (this.coordinates.getHeight() > 100)
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLongitude(),
					100);
		else if (this.coordinates.getHeight() <= 0)
		{
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLongitude(), 0);
			Logger.getLogger().printMessage("Tower says : " + this.identifier + " unregistered from Weather Tower");
			Logger.getLogger().printMessage(this.identifier + " : Landing coordinate = " + this.coordinates.getLongitude() +
					" " + this.coordinates.getLatitude() + " " + this.coordinates.getHeight());
			this.weatherTower.unregister(this);
		}
	}
}
