package fr.avaj_launcher.vehicule_observer;

import fr.avaj_launcher.vehicule.Flyable;

public abstract class Tower
{
	/*
        Attributes
     */

	private Flyable[] observers;

    /*
        Methods
     */

	public void register(Flyable flyable)
	{
	}

	public void unregister(Flyable flyable)
	{
	}

	protected void conditionsChanged()
	{
	}
}
