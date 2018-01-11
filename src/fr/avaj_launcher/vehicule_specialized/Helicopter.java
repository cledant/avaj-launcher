package fr.avaj_launcher.vehicule_specialized;

import com.sun.org.apache.bcel.internal.classfile.Unknown;
import fr.avaj_launcher.exception.TooMuchAircraftException;
import fr.avaj_launcher.vehicule_base.Aircraft;
import fr.avaj_launcher.vehicule_base.Coordinates;
import fr.avaj_launcher.vehicule_base.Flyable;
import fr.avaj_launcher.vehicule_observer.WeatherTower;

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
	public void registerTower(WeatherTower WeatherTower)
	{
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}

	@Override
	public void updateConditions()
	{
		if (this.weatherTower == null)
			throw UnregistredTower();
		String weather = this.weatherTower.getWeather(this.coordinates);
		if (weather.compareTo("SUN") == 0)
		{
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
			this.coordinates.setHeight(this.coordinates.getHeight() + 2);
		}
		else if (weather.compareTo("RAIN") == 0)
		{
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
		}
		else if (weather.compareTo("FOG") == 0)
		{
			this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
		}
		else if (weather.compareTo("SNOW") == 0)
		{
			this.coordinates.setHeight(this.coordinates.getHeight() - 12);
		}
		else
			throw UnknownWeather();
	}

	@Override
	public String generateIdentifier()
	{
		String tmp;

		tmp = "Helicopter#" + this.name + "(" + String.valueOf(this.id) + ")";
		return (tmp);
	}
}
