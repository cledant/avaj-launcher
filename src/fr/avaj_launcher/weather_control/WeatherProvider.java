package fr.avaj_launcher.weather_control;

import fr.avaj_launcher.vehicule.Coordinates;

import java.util.Random;

public class WeatherProvider
{
	/*
        Attributes
     */

	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
	private Random random;
	private int seed_x;
	private int seed_y;
	private int seed_z;

    /*
        Constructor
     */

	private WeatherProvider()
	{
		this.newSeed();
	}

    /*
        Methods
     */

	public static WeatherProvider getProvider()
	{
		return (weatherProvider);
	}

	public String getCurrentWeather(Coordinates coordinates)
	{
		int tmp = (this.seed_x - coordinates.getLongitude()) + (this.seed_y - coordinates.getLatitude()) +
				(this.seed_z - coordinates.getHeight());
		return (weather[Math.abs(tmp % 4)]);
	}

	public void newSeed()
	{
		this.random = new Random(System.currentTimeMillis());
		this.seed_x = random.nextInt();
		this.seed_y = random.nextInt();
		this.seed_z = random.nextInt();
	}
}
