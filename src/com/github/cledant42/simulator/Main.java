package com.github.cledant42.simulator;

import com.github.cledant42.exception.*;
import com.github.cledant42.logger.Logger;

import java.io.IOException;

public class Main
{
	private static void run(String[] args) throws InvalidCycleNumberException, TooMuchAircraftException, UnknownAircraftTypeException,
			InvalidAircraftHeightException, InvalidAircraftLongitudeException, InvalidAircraftLatitudeException,
			InvalidAircraftFormatException, UnknownWeatherException, UnregisteredTowerException, IOException
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
