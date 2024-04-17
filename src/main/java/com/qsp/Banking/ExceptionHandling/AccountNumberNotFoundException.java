package com.qsp.Banking.ExceptionHandling;

public class AccountNumberNotFoundException extends Exception{
@Override
public String getMessage() {

	return "Account number is not found.. Plz provide valid Account number";
}
	
}
