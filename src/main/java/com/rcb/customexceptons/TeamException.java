package com.rcb.customexceptons;

@SuppressWarnings("serial")
public class TeamException extends RuntimeException{

	public TeamException(String exceptionMessage)
	{
		super(exceptionMessage);
	}
	
}
