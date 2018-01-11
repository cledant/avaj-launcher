package fr.avaj_launcher.vehicule_observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

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
	}

	public void unregister(Flyable flyable) throws IOException
	{
		System.out.println("AAA");
		System.out.println(this.observers.remove(flyable));
		System.out.println(this.observers);
		System.out.println("BBB");
	}

	protected void conditionsChanged() throws IOException, UnknownWeatherException, UnregisteredTowerException
	{
		ListIterator<Flyable> lit = this.observers.listIterator();
		Flyable tmp = null;
		boolean loop = lit.hasNext();

		while (loop)
		{
			tmp = lit.next();
			loop = lit.hasNext();
			System.out.println(loop);
			System.out.println(tmp);
			tmp.updateConditions();
			System.out.println(this.observers);
		}
	}
}
