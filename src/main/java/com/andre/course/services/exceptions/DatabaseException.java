package com.andre.course.services.exceptions;

public class DatabaseException extends RuntimeException{

	private static final long serialVersionUID = -3106390859880728980L;
	
	public DatabaseException (String msg) {
		super(msg);
	}
}
