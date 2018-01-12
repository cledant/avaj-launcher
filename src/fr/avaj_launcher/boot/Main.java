package fr.avaj_launcher.boot;

import fr.avaj_launcher.exception.*;
import fr.avaj_launcher.logger.Logger;
import fr.avaj_launcher.simulator.Simulator;

import java.io.IOException;

public class Main
{
	private static void run(String[] args) throws InvalidCycleNumberException, TooMuchAircraftException, UnknownAircraftTypeException,
			InvalidAircraftHeightException, InvalidAircraftFormatException, UnknownWeatherException, UnregisteredTowerException,
			IOException
	{
		Simulator simu = new Simulator(args[0]);

		simu.parseCycleNumber();
		simu.parseAircraft();
		simu.simulate();
	}

	public static void main(String[] args)
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
