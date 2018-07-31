/**
 * 
 */
package com.ingenico.nl.dto;

/**
 * @author Ankit
 *This UserTransactionDTO class which keep the properties of transaction data field.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class UserTransactionDTO {

	/**
	 * The currencyCode field
	 */
	@JsonProperty(required = true)
	private String currencyCode;

	/**
	 * The transaction amount field
	 */
	@JsonProperty(required = true)
	private BigDecimal amount;

	/**
	 * The payee account id field
	 */
	@JsonProperty(required = true)
	private Long fromAccountId;

	/**
	 * The beneficiary account id field
	 */
	@JsonProperty(required = true)
	private Long toAccountId;

	/**
	 * UserTransactionDTO constructor
	 */
	public UserTransactionDTO() {
	}

	/**
	 * UserTransactionDTO constructor
	 * 
	 * @param currencyCode
	 * @param amount
	 * @param fromAccountId
	 * @param toAccountId
	 */
	public UserTransactionDTO(String currencyCode, BigDecimal amount, Long fromAccountId, Long toAccountId) {
		this.currencyCode = currencyCode;
		this.amount = amount;
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
	}

	/**
	 * @return currencyCode
	 */
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * @return amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @return fromAccountId
	 */
	public Long getFromAccountId() {
		return fromAccountId;
	}

	/**
	 * @return toAccountId
	 */
	public Long getToAccountId() {
		return toAccountId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserTransactionDTO that = (UserTransactionDTO) o;

		if (!currencyCode.equals(that.currencyCode))
			return false;
		if (!amount.equals(that.amount))
			return false;
		if (!fromAccountId.equals(that.fromAccountId))
			return false;
		return toAccountId.equals(that.toAccountId);

	}

	@Override
	public int hashCode() {
		int result = currencyCode.hashCode();
		result = 31 * result + amount.hashCode();
		result = 31 * result + fromAccountId.hashCode();
		result = 31 * result + toAccountId.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "UserTransaction{" + "currencyCode='" + currencyCode + '\'' + ", amount=" + amount + ", fromAccountId="
				+ fromAccountId + ", toAccountId=" + toAccountId + '}';
	}

}