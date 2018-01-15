package fr.avaj_launcher.vehicule_observer;

import fr.avaj_launcher.exception.UnknownAircraftTypeException;
import fr.avaj_launcher.exception.UnknownWeatherException;
import fr.avaj_launcher.exception.UnregisteredTowerException;
import fr.avaj_launcher.vehicule.Coordinates;
import fr.avaj_launcher.weather_control.WeatherProvider;

import java.io.IOException;

public class WeatherTower extends Tower
{
	/*
		Methods
     */

	public String getWeather(Coordinates coordinates)
	{
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}

	public void changeWeather() throws IOException, UnknownAircraftTypeException, UnregisteredTowerException,
			UnknownWeatherException
	{
		WeatherProvider.getProvider().newSeed();
		this.conditionsChanged();
	}
}
