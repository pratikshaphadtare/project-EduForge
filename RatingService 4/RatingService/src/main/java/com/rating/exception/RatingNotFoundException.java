package com.rating.exception;

@SuppressWarnings("serial")
public class RatingNotFoundException extends RuntimeException{
	
	public RatingNotFoundException(String message) {
        super(message);
        
	}

}
