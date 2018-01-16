package com.github.cledant42.vehicule;

import com.github.cledant42.exception.UnknownWeatherException;
import com.github.cledant42.exception.UnregisteredTowerException;
import com.github.cledant42.vehicule_observer.WeatherTower;

import java.io.IOException;

public interface Flyable
{
	void updateConditions() throws IOException, UnknownWeatherException, UnregisteredTowerException;

	void registerTower(WeatherTower weatherTower) throws IOException;
}
