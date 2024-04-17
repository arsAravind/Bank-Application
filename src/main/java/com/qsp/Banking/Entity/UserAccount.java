package com.qsp.Banking.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_ACCOUNT")
public class UserAccount {

	@Id
	private int accountNumber;
	private String accountHolderName;
	private long accountBalance;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Id")
	private UserDetails details;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public long getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}

	public UserDetails getDetails() {
		return details;
	}

	public void setDetails(UserDetails details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "User_Account [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
				+ ", accountBalance=" + accountBalance + "]";
	}

}
