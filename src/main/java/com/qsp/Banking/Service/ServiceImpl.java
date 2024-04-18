package com.qsp.Banking.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qsp.Banking.Entity.UserAccount;
import com.qsp.Banking.Entity.UserDetails;
import com.qsp.Banking.ExceptionHandling.AccountNumberNotFoundException;
import com.qsp.Banking.ExceptionHandling.InsufficientAmountException;
import com.qsp.Banking.ExceptionHandling.RecipentAccountNumberNotFoundException;
import com.qsp.Banking.Repo.Repo;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service {
	@Autowired
	Repo repo;

	public String create(UserAccount account) {
		repo.save(account);
		return "Account created successfully";
	}

	public UserAccount fetch(int id) throws AccountNumberNotFoundException {
		UserAccount us = repo.findByAccountNumber(id);
		if (us != null) {
			return us;
		} else {
			throw new AccountNumberNotFoundException();
		}
	}

	@Override
	public String deposit(int id, long amount) throws AccountNumberNotFoundException {
		UserAccount us = repo.findByAccountNumber(id);
		if (us != null) {
			long l = us.getAccountBalance() + amount;
			us.setAccountBalance(l);
		} else {
			throw new AccountNumberNotFoundException();
		}
		repo.save(us);
		long total = us.getAccountBalance();
		return "Total amount after deposit is =" + total;
	}

	@Override
	public String withdraw(int id, long amount) throws InsufficientAmountException, AccountNumberNotFoundException {
		UserAccount acc = repo.findByAccountNumber(id);
		if (acc != null) {
			if (amount < acc.getAccountBalance()) {
				long l = acc.getAccountBalance() - amount;
				acc.setAccountBalance(l);
			} else {
				throw new InsufficientAmountException();
			}

		} else {
			throw new AccountNumberNotFoundException();
		}
		repo.save(acc);
		String s = "Total amount after withdrawal =" + acc.getAccountBalance();
		return s;
	}

	@Override
	public String delete(int id) throws AccountNumberNotFoundException {
		UserAccount acc = repo.findByAccountNumber(id);
		if (acc != null) {
			repo.delete(acc);
		} else {
			throw new AccountNumberNotFoundException();
		}
		repo.save(acc);
		return "Account deleted Successfully";
	}

	@Override
	public String balance(int id) throws AccountNumberNotFoundException {
		UserAccount acc = repo.findById(id).orElseThrow(() -> new AccountNumberNotFoundException());
		
			return "Balance amount is " + acc.getAccountBalance();
//		} else {
//			throw new AccountNumberNotFoundException();
//		}
	}

	@Override
	public String transfer(int a, int b, long acc)
			throws InsufficientAmountException, RecipentAccountNumberNotFoundException, AccountNumberNotFoundException {
		UserAccount p1 = repo.findByAccountNumber(a);
		if (p1 != null) {
			UserAccount p2 = repo.findByAccountNumber(b);
			if (p2 != null) {
				if (acc < p1.getAccountBalance()) {
					long l = acc + p2.getAccountBalance();
					p2.setAccountBalance(l);
					repo.save(p2);
				} else {
					throw new InsufficientAmountException();
				}

			} else {
				throw new RecipentAccountNumberNotFoundException();
			}

		} else {
			throw new AccountNumberNotFoundException();
		}
		long l = p1.getAccountBalance() - acc;
		p1.setAccountBalance(l);
		repo.save(p1);
		String s = "After transfer the money to next person =" + p1.getAccountBalance();
		return s;
	}

	@Override
	public List<UserAccount> fetchAll() {
		List<UserAccount> findAll = repo.findAll();
		return findAll;
	}

	@Override
	public List<UserAccount> salary(long accountBalance) {
		List<UserAccount> list=repo.findAllSalary(accountBalance);
		return list;
	}

}
