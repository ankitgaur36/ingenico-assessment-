package com.ingenico.nl.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ankit 
 * This Account Entity class which keep the Column of Account
 * table.
 */

/**
 * @author AG90947
 *
 */
@Entity
@Table(name = "account")
public class Account {
	/**
	 * accountId field for id column key
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long accountId;

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	/**
	 * userName field for username column
	 */

	@Column(name = "username")
	private String userName;

	/**
	 * balance field for balance column
	 */
	@Column(name = "balance")
	private BigDecimal balance;

	/**
	 * currencyCode field for currencycode column
	 */
	@Column(name = "currencycode")
	private String currencyCode;

	/**
	 * @param accountId
	 * @param userName
	 * @param balance
	 * @param currencyCode
	 */
	public Account(Long accountId, String userName, BigDecimal balance, String currencyCode) {
		this.accountId = accountId;
		this.userName = userName;
		this.balance = balance;
		this.currencyCode = currencyCode;
	}

	/**
	 * Account constructor
	 */
	public Account() {
	}

	/**
	 * @return accountId
	 */
	public Long getAccountId() {
		return accountId;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	/**
	 * @return currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @param currencyCode
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

}
