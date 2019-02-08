package com.bakalis.struts.services;

/*
 * 
 * Simple Service that Keeps an Error String to be checked by and Used in other Services and Controllers.
 * 
 * */
public class ErrorLoggingService {

	protected static String error = null;

	public static String getError() {
		return error;
	}

	public static void setError(String error) {
		ErrorLoggingService.error = error;
	}
	
	
	public static boolean errorExists(){
		if(error==null)
			return false;
		else
			return true;
	}
	
	public static void reset(){
		ErrorLoggingService.setError(null);
	}
		
	
}
