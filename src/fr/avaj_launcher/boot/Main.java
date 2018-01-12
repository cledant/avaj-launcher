package fr.avaj_launcher.boot;

import fr.avaj_launcher.exception.InvalidCycleNumberException;
import fr.avaj_launcher.exception.TooMuchAircraftException;
import fr.avaj_launcher.logger.Logger;
import fr.avaj_launcher.simulator.Parser;
import fr.avaj_launcher.simulator.Simulator;
import fr.avaj_launcher.vehicule_base.Flyable;
import fr.avaj_launcher.vehicule_factory.AircraftFactory;
import fr.avaj_launcher.vehicule_observer.WeatherTower;

import java.io.IOException;

public class Main
{
	private static void testFactoryAndWeatherTower() throws TooMuchAircraftException
	{
		AircraftFactory factory = null;
		Flyable tmp = null;
		WeatherTower wt = null;
		int nb_iter = 20;

		try
		{
			System.out.println("Generating AircraftFactory");
			factory = new AircraftFactory();

			System.out.println("Generating Weather Tower");
			wt = new WeatherTower();

			System.out.println("Generating JetPlane");
			tmp = factory.newAircraft("JetPlane", "Totor", -200, 200, 50);
			System.out.println("Registering Weather Tower to JetPlane");
			tmp.registerTower(wt);

			System.out.println("Generating Baloon");
			tmp = factory.newAircraft("Baloon", "Toto", 200, -200, 99);
			System.out.println("Registering Weather Tower to Baloon");
			tmp.registerTower(wt);

			System.out.println("Generating Helicopter");
			tmp = factory.newAircraft("Helicopter", "Peon", 200, 400, 30);
			System.out.println("Registering Weather Tower to Helicopter");
			tmp.registerTower(wt);

			System.out.println("Generating JetPlane");
			tmp = factory.newAircraft("JetPlane", "Totor", -200, 200, 50);
			System.out.println("Registering Weather Tower to JetPlane");
			tmp.registerTower(wt);

			System.out.println("Generating Baloon");
			tmp = factory.newAircraft("Baloon", "Toto", 200, -200, 99);
			System.out.println("Registering Weather Tower to Baloon");
			tmp.registerTower(wt);

			System.out.println("Generating Helicopter");
			tmp = factory.newAircraft("Helicopter", "Peon", 200, 400, 30);
			System.out.println("Registering Weather Tower to Helicopter");
			tmp.registerTower(wt);

			System.out.println("Generating JetPlane");
			tmp = factory.newAircraft("JetPlane", "Totor", -200, 200, 50);
			System.out.println("Registering Weather Tower to JetPlane");
			tmp.registerTower(wt);

			System.out.println("Generating Baloon");
			tmp = factory.newAircraft("Baloon", "Toto", 200, -200, 99);
			System.out.println("Registering Weather Tower to Baloon");
			tmp.registerTower(wt);

			System.out.println("Generating Helicopter");
			tmp = factory.newAircraft("Helicopter", "Peon", 200, 400, 30);
			System.out.println("Registering Weather Tower to Helicopter");
			tmp.registerTower(wt);

			System.out.println("Generating JetPlane");
			tmp = factory.newAircraft("JetPlane", "Totor", -200, 200, 50);
			System.out.println("Registering Weather Tower to JetPlane");
			tmp.registerTower(wt);

			System.out.println("Generating Baloon");
			tmp = factory.newAircraft("Baloon", "Toto", 200, -200, 99);
			System.out.println("Registering Weather Tower to Baloon");
			tmp.registerTower(wt);

			System.out.println("Generating Helicopter");
			tmp = factory.newAircraft("Helicopter", "Peon", 200, 400, 30);
			System.out.println("Registering Weather Tower to Helicopter");
			tmp.registerTower(wt);

			System.out.println("Running Simulation");
			for (int i = nb_iter; i > 0; i--)
				wt.changeWeather();
			System.out.println("Simulation Ended");
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	private static void run(String[] args) throws IOException, InvalidCycleNumberException
	{
		Simulator simu =  new Simulator(args[0]);

		simu.parseCycleNumber();
	}

	public static void main(String[] args) throws TooMuchAircraftException
	{
		if (args.length == 0)
			System.out.println("Not enough argument");
		else if (args.length > 1)
			System.out.println("Too much arguments");
		else
		{
			try
			{
				run(args);
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
			try
			{
				Logger.getLogger().closeFile();
			}
			catch (Exception e)
			{
				System.out.println("Failed to close simulation.txt");
			}
		}
	}
}
