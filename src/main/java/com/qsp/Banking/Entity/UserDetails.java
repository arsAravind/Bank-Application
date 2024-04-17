package com.qsp.Banking.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserDetails {
	@Id
	private int id;
	private String userName;
	private String userPlace;
	private String userNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPlace() {
		return userPlace;
	}

	public void setUserPlace(String userPlace) {
		this.userPlace = userPlace;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	@Override
	public String toString() {
		return "User_Details [id=" + id + ", userName=" + userName + ", userPlace=" + userPlace + ", userNumber="
				+ userNumber + "]";
	}

}
