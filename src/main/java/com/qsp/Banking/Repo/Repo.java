package com.qsp.Banking.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qsp.Banking.Entity.UserAccount;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@Repository
public interface Repo extends JpaRepository<UserAccount, Integer> {

	UserAccount findByAccountNumber(int id);

}
