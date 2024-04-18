package com.qsp.Banking.Controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.Banking.Entity.UserAccount;
import com.qsp.Banking.Entity.UserDetails;
import com.qsp.Banking.ExceptionHandling.AccountNumberNotFoundException;
import com.qsp.Banking.ExceptionHandling.InsufficientAmountException;
import com.qsp.Banking.ExceptionHandling.RecipentAccountNumberNotFoundException;
import com.qsp.Banking.Service.Service;

@RestController
@RequestMapping("/useracc")
public class Controller {
	@Autowired
	Service service;

	@PostMapping("/createAccount")
	public ResponseEntity<?> createUserId(@RequestBody UserAccount account) {
		String s = service.create(account);
		return new ResponseEntity<>(s, HttpStatus.ACCEPTED);
	}

	@GetMapping("/fetch/{id}")
	public ResponseEntity<?> fetch(@PathVariable int id) throws AccountNumberNotFoundException {
		UserAccount us = service.fetch(id);
		return new ResponseEntity<>(us, HttpStatus.ACCEPTED);
	}

	@PutMapping("/deposit/{id}/{amount}")
	public ResponseEntity<?> deposit(@PathVariable int id, @PathVariable long amount)
			throws AccountNumberNotFoundException {
		String deposit = service.deposit(id, amount);
		return new ResponseEntity<>(deposit, HttpStatus.ACCEPTED);
	}

	@PutMapping("/withdraw/{id}/{amount}")
	public ResponseEntity<?> withdraw(@PathVariable int id, @PathVariable long amount)
			throws InsufficientAmountException, AccountNumberNotFoundException {
		String withdraw = service.withdraw(id, amount);
		return new ResponseEntity<>(withdraw, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) throws AccountNumberNotFoundException {
		String delete = service.delete(id);
		return new ResponseEntity<>(delete, HttpStatus.ACCEPTED);
	}

	@GetMapping("/balance/{id}")
	public ResponseEntity<?> balance(@PathVariable int id) throws AccountNumberNotFoundException {
		String balance = service.balance(id);
		return new ResponseEntity<>(balance, HttpStatus.ACCEPTED);
	}

	@PutMapping("/transfer/{a}/{b}/{acc}")
	public ResponseEntity<?> transfer(@PathVariable int a, @PathVariable int b, @PathVariable long acc)
			throws InsufficientAmountException, RecipentAccountNumberNotFoundException, AccountNumberNotFoundException {
		String transfer = service.transfer(a, b, acc);
		return new ResponseEntity<>(transfer, HttpStatus.ACCEPTED);
	}

	@GetMapping("/fetchAll")
	public ResponseEntity<?> fetchAll() {
		List<UserAccount> fetchAll = service.fetchAll();
		return new ResponseEntity<>(fetchAll, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/salarycriteria/{sal}")
	public ResponseEntity<?> salary(@PathVariable long accountBalance) {
		List<UserAccount> fetchAll = service.salary(accountBalance);
		return new ResponseEntity<>(fetchAll, HttpStatus.ACCEPTED);
	}

}
