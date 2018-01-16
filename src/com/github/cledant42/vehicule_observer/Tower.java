package com.github.cledant42.vehicule_observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

import com.github.cledant42.exception.*;
import com.github.cledant42.vehicule.Flyable;

public abstract class Tower
{
	/*
		Attributes
     */

	private ArrayList<Flyable> observers = null;
	private ListIterator<Flyable> lit = null;

    /*
		Methods
     */

	public void register(Flyable flyable) throws IOException
	{
		if (this.observers == null)
			this.observers = new ArrayList<Flyable>();
		this.observers.add(flyable);
		this.lit = this.observers.listIterator();
	}

	public void unregister(Flyable flyable) throws IOException
	{
		if (this.observers == null)
			return ;
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
		Flyable tmp = null;

		if (this.observers == null)
			return ;
		this.lit = this.observers.listIterator();
		boolean loop = this.lit.hasNext();
		while (loop)
		{
			tmp = this.lit.next();
			tmp.updateConditions();
			loop = this.lit.hasNext();
		}
	}
}
