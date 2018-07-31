package com.ingenico.nl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ingenico.nl.entity.Account;

/**
 * @author Ankit 
 * 
 *AccountRepository interface 
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
}
