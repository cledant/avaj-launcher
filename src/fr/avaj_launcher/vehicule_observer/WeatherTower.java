package fr.avaj_launcher.vehicule_observer;

import fr.avaj_launcher.vehicule.Coordinates;
import fr.avaj_launcher.weather_control.WeatherProvider;

public class WeatherTower extends Tower
{
	/*
		Methods
     */

	public String getWeather(Coordinates coordinates)
	{
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}

	public void changeWeather()
	{
		WeatherProvider.getProvider().newSeed();
	}
}
