package com.qsp.Banking.Service;

import java.util.List;

import com.qsp.Banking.Entity.UserAccount;
import com.qsp.Banking.Entity.UserDetails;
import com.qsp.Banking.ExceptionHandling.AccountNumberNotFoundException;
import com.qsp.Banking.ExceptionHandling.InsufficientAmountException;
import com.qsp.Banking.ExceptionHandling.RecipentAccountNumberNotFoundException;

public interface Service {

	String create(UserAccount account);

	UserAccount fetch(int id) throws AccountNumberNotFoundException;

	String deposit(int id, long amount) throws AccountNumberNotFoundException;

	String withdraw(int id, long amount) throws InsufficientAmountException, AccountNumberNotFoundException;

	String delete(int id) throws AccountNumberNotFoundException;

	String balance(int id) throws AccountNumberNotFoundException;

	String transfer(int a, int b, long acc)
			throws InsufficientAmountException, RecipentAccountNumberNotFoundException, AccountNumberNotFoundException;

	List<UserAccount> fetchAll();

	List<UserAccount> salary(long accountBalance);

}
