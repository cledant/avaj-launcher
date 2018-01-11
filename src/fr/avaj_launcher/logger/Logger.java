package fr.avaj_launcher.logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger
{
	private static Logger logger = null;
	private PrintWriter printWriter;

	public static Logger getInstance() throws FileNotFoundException, IOException
	{
		if (logger == null)
			logger = new Logger();
		return (logger);
	}

	private Logger() throws FileNotFoundException, IOException
	{
		printWriter = new PrintWriter("./simulation.txt");
	}
}
