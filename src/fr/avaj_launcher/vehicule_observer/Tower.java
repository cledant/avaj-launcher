package fr.avaj_launcher.vehicule_observer;

import fr.avaj_launcher.vehicule.Flyable;

public abstract class Tower
{
    /*
        Attribute
     */

    private Flyable[] observers;

    /*
        Methode
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
