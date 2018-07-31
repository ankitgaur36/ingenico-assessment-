/**
 * 
 */
package com.ingenico.nl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ingenico.nl.entity.UserTransaction;

/**
 * @author Ankit
 * 
 *UserTransactionRepositry Intertface 
 */
public interface UserTransactionRepositry extends JpaRepository<UserTransaction, Long> {

}

