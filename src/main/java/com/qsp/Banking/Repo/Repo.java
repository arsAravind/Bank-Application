package com.qsp.Banking.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qsp.Banking.Entity.UserAccount;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@Repository
public interface Repo extends JpaRepository<UserAccount, Integer> {

	UserAccount findByAccountNumber(int id);

	//@Query(value = "select * from USER_ACCOUNT where account_balance>?1",nativeQuery = true)
	@Query(value = "SELECT * FROM USER_ACCOUNT WHERE account_balance > ?1", nativeQuery = true)
	List<UserAccount> findAllSalary(long accountBalance);

}
