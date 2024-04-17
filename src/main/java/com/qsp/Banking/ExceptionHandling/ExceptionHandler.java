package com.qsp.Banking.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(AccountNumberNotFoundException.class)
	public ResponseEntity<?> accNumberHandle(AccountNumberNotFoundException acc)
	{
		return new ResponseEntity<>(acc.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler(InsufficientAmountException.class)
	public ResponseEntity<?> insufficientBalanceHandle(InsufficientAmountException ins)
	{
		return new ResponseEntity<>(ins.getMessage(),HttpStatus.BAD_REQUEST);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler(RecipentAccountNumberNotFoundException.class)
	public ResponseEntity<?> numberMismatchHandle(RecipentAccountNumberNotFoundException rs)
	{
		return new ResponseEntity<>(rs.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
}
