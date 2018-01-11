package fr.avaj_launcher.vehicule_base;

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

	public void setLongitude(int longitude)
	{
		this.longitude = longitude;
	}

	public void setLatitude(int latitude)
	{
		this.latitude = latitude;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}
}
