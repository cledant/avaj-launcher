package com.github.cledant42.exception;

public class UnregisteredTowerException extends Exception
{
	public UnregisteredTowerException()
	{
		super("Aircraft not registred to a tower");
	}
}
