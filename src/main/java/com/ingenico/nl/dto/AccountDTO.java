package com.ingenico.nl.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/* This is Account bean class which have the Account properties.
*/
public class AccountDTO {

	/**
	 * The accountId field
	 */
	@JsonProperty
	private long accountId;

	/**
	 * The userName field
	 */
	@JsonProperty(required = true)
	private String userName;

	/**
	 * The balance field
	 */
	@JsonProperty(required = true)
	private BigDecimal balance;

	/**
	 * The currencyCode field
	 */
	@JsonProperty(required = true)
	private String currencyCode;

	/**
	 * AccountDTO constructor
	 */
	public AccountDTO() {

	}

	/**
	 * the AccountDTO constructor
	 * 
	 * @param accountId
	 * @param userName
	 * @param balance
	 * @param currencyCode
	 */
	public AccountDTO(long accountId, String userName, BigDecimal balance, String currencyCode) {
		this.accountId = accountId;
		this.userName = userName;
		this.balance = balance;
		this.currencyCode = currencyCode;
	}

	/**
	 * @return accountId
	 */
	public long getAccountId() {
		return accountId;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @return balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * @return currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		AccountDTO account = (AccountDTO) o;

		if (accountId != account.accountId)
			return false;
		if (!userName.equals(account.userName))
			return false;
		if (!balance.equals(account.balance))
			return false;
		return currencyCode.equals(account.currencyCode);

	}

	@Override
	public int hashCode() {
		int result = (int) (accountId ^ (accountId >>> 32));
		result = 31 * result + userName.hashCode();
		result = 31 * result + balance.hashCode();
		result = 31 * result + currencyCode.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Account{" + "accountId=" + accountId + ", userName='" + userName + '\'' + ", balance=" + balance
				+ ", currencyCode='" + currencyCode + '\'' + '}';
	}
}
