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

	WeatherTower weatherTower = null;

	/*
		Constructor
	 */

	public Helicopter(String name, Coordinates coordinates) throws TooMuchAircraftException
	{
		super(name, coordinates);
	}

	/*
		Methods
	 */

	@Override
	public void registerTower(WeatherTower weatherTower) throws IOException
	{
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}

	@Override
	public void updateConditions() throws IOException, UnknownWeatherException, UnregisteredTowerException
	{
		if (this.weatherTower == null)
			throw new UnregisteredTowerException();
		String weather = this.weatherTower.getWeather(this.coordinates);
		if (weather.compareTo("SUN") == 0)
		{
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
			this.coordinates.setHeight(this.coordinates.getHeight() + 2);
			Logger.getLogger().printMessage(this.generateIdentifier() + ": SUN");
		}
		else if (weather.compareTo("RAIN") == 0)
		{
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
			Logger.getLogger().printMessage(this.generateIdentifier() + ": RAIN");
		}
		else if (weather.compareTo("FOG") == 0)
		{
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
			Logger.getLogger().printMessage(this.generateIdentifier() + ": FOG");
		}
		else if (weather.compareTo("SNOW") == 0)
		{
			this.coordinates.setHeight(this.coordinates.getHeight() - 12);
			Logger.getLogger().printMessage(this.generateIdentifier() + ": SNOW");
		}
		else
			throw new UnknownWeatherException();
		if (this.coordinates.getHeight() > 100)
			this.coordinates.setHeight(100);
		else if (this.coordinates.getHeight() <= 0)
			this.weatherTower.unregister(this);
	}

	@Override
	public String generateIdentifier()
	{
		String tmp;

		tmp = "Helicopter#" + this.name + "(" + String.valueOf(this.id) + ")";
		return (tmp);
	}
}
