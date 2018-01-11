package fr.avaj_launcher.vehicule_base;

import fr.avaj_launcher.exception.UnknownWeatherException;
import fr.avaj_launcher.exception.UnregisteredTowerException;
import fr.avaj_launcher.vehicule_observer.WeatherTower;

import java.io.IOException;

public interface Flyable
{
	void updateConditions() throws IOException, UnknownWeatherException, UnregisteredTowerException;

	void registerTower(WeatherTower weatherTower) throws IOException;
}
