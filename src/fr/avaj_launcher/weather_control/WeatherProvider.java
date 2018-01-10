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
        Methode
     */

    public static WeatherProvider getProvider()
    {
        return (weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        return (weather[0]);
    }

    public void newSeed()
    {
        this.random = new Random(System.currentTimeMillis());
        this.seed_x = random.nextInt();
        this.seed_y = random.nextInt();
        this.seed_z = random.nextInt();
    }
}
