package fr.avaj_launcher.vehicule_observer;

import java.util.ArrayList;
import java.util.Iterator;

import fr.avaj_launcher.vehicule.Flyable;

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

	public void register(Flyable flyable)
	{
		this.observers.add(flyable);
	}

	public void unregister(Flyable flyable)
	{
		this.observers.remove(flyable);
	}

	protected void conditionsChanged()
	{
		Iterator<Flyable> it = this.observers.iterator();

		while (it.hasNext())
			it.next().updateConditions();
	}
}
