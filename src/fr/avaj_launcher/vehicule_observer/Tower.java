package fr.avaj_launcher.vehicule_observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

import fr.avaj_launcher.exception.UnknownWeatherException;
import fr.avaj_launcher.exception.UnregisteredTowerException;
import fr.avaj_launcher.vehicule.Flyable;

public abstract class Tower
{
	/*
		Attributes
     */

	private ArrayList<Flyable> observers = null;
	private ListIterator<Flyable> lit = null;

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
		this.lit = this.observers.listIterator();
	}

	public void unregister(Flyable flyable) throws IOException
	{
		int index = this.observers.indexOf(flyable);

		if (index != 0)
			this.lit = this.observers.listIterator(index);
		else
			this.lit = this.observers.listIterator();
		this.lit.next();
		this.lit.remove();
	}

	protected void conditionsChanged() throws IOException, UnknownWeatherException, UnregisteredTowerException
	{
		this.lit = this.observers.listIterator();
		Flyable tmp = null;
		boolean loop = this.lit.hasNext();

		while (loop)
		{
			tmp = this.lit.next();
			tmp.updateConditions();
			loop = this.lit.hasNext();
		}
	}
}
