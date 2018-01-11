package fr.avaj_launcher.vehicule_observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import fr.avaj_launcher.exception.UnknownWeatherException;
import fr.avaj_launcher.exception.UnregisteredTowerException;
import fr.avaj_launcher.logger.Logger;
import fr.avaj_launcher.vehicule_base.Flyable;
import fr.avaj_launcher.weather_control.WeatherProvider;

public abstract class Tower
{
	/*
		Attributes
     */

	private ArrayList<Flyable> observers;

	/*
		Constructor
	 */

	public Tower()
	{
		this.observers = new ArrayList<Flyable>();
	}

    /*
		Methods
     */

	public void register(Flyable flyable) throws IOException
	{
		this.observers.add(flyable);
		Logger.getLogger().printMessage("Tower says : " + flyable.generateIdentifier() + "registered to Weather Tower");
	}

	public void unregister(Flyable flyable) throws IOException
	{
		this.observers.remove(flyable);
		Logger.getLogger().printMessage("Tower says : " + flyable.generateIdentifier() + "unregistered from Weather Tower");
	}

	protected void conditionsChanged() throws IOException, UnknownWeatherException, UnregisteredTowerException
	{
		Iterator<Flyable> it = this.observers.iterator();

		while (it.hasNext())
			it.next().updateConditions();
	}
}
