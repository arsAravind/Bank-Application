package com.qsp.Banking.ExceptionHandling;

public class InsufficientAmountException extends Exception {

	@Override
	public String getMessage() {

		return "Insuffient balance";
	}
}
