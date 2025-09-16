package com.oracle.spring_account_service.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oracle.spring_account_service.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
