package fr.avaj_launcher.vehicule_base;

import fr.avaj_launcher.vehicule_observer.WeatherTower;

public interface Flyable
{
	void updateConditions();

	void registerTower(WeatherTower WeatherTower);

	String generateIdentifier();
}
