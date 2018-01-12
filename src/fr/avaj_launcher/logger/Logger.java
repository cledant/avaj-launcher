package fr.avaj_launcher.logger;

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

	private Logger() throws IOException
	{
		printWriter = new PrintWriter("./simulation.txt");
	}

	/*
		Methods
	 */

	public static Logger getLogger() throws IOException
	{
		if (logger == null)
			logger = new Logger();
		return (logger);
	}

	public void printMessage(String msg) throws IOException
	{
		this.printWriter.println(msg);
	}

	public void closeFile()
	{
		this.printWriter.close();
	}
}
