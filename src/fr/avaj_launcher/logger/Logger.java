package fr.avaj_launcher.logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger
{
	private static Logger logger = null;
	private PrintWriter printWriter;

	/*
		Constructor
	 */

	private Logger() throws FileNotFoundException, IOException
	{
		printWriter = new PrintWriter("./simulation.txt");
	}

	/*
		Methods
	 */

	public static Logger getLogger() throws FileNotFoundException, IOException
	{
		if (logger == null)
		{
			System.out.println("Generating Logger");
			logger = new Logger();
		}
		return (logger);
	}

	public void printMessage(String msg) throws IOException
	{
		System.out.println(msg);
		this.printWriter.println(msg);
	}
}
