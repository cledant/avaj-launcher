package com.github.cledant42.vehicule_observer;

import com.github.cledant42.exception.*;
import com.github.cledant42.vehicule.Coordinates;
import com.github.cledant42.weather_control.WeatherProvider;

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
