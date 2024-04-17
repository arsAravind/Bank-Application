package com.qsp.Banking.ExceptionHandling;

public class RecipentAccountNumberNotFoundException extends Exception{

	@Override
	public String getMessage() {
		
		return "Receipient account number is invalid";
	}
}
