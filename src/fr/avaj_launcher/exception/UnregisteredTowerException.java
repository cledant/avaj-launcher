package fr.avaj_launcher.exception;

public class UnregisteredTowerException extends Exception
{
	public UnregisteredTowerException()
	{
		super("Aircraft not registred to a tower");
	}
}
