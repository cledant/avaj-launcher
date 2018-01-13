package fr.avaj_launcher.vehicule;

public class Coordinates
{
	/*
		Attributes
     */

	private int longitude;
	private int latitude;
	private int height;

    /*
		Constructor
     */

	public Coordinates(int longitude, int latitude, int height)
	{
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

    /*
		Methods
     */

	public int getLongitude()
	{
		return (this.longitude);
	}

	public int getLatitude()
	{
		return (this.latitude);
	}

	public int getHeight()
	{
		return (this.height);
	}
}
