package fr.avaj_launcher.vehicule;

public abstract class Aircraft
{
    /*
        Attributes
     */

    private static long idCounter = 0;

    protected long id;
    protected String name;
    protected Coordinates coordinates;

    /*
        Constructor
     */

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.coordinates = coordinates;
        this.name = name;
        this.id = Aircraft.nextId();
    }

    /*
        Method
     */

    private static long nextId()
    {
        idCounter++;
        return (idCounter);
    }
}
