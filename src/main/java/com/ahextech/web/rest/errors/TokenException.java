package com.ahextech.web.rest.errors;

public class TokenException extends Exception {
    String message="Token is invalid,no user exists with the token";

	public TokenException(String message) {
		super();
		this.message = message;
	}
    
    
}
