/**
 * 
 */
package com.ingenico.nl.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ankit.
 *  This UserTransaction Entity class which keep the Column of transaction
 *  table.
 */

@Entity
@Table(name = "transaction")
public class UserTransaction {

	
	/**
	 * transaction_id field for id transactionId key
	 */	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private Long transactionId;


	/**
	 * currencyCode field for currencycode column
	 */	
	@Column(name = "currencycode")
	private String currencyCode;


	/**
	 * amount field for amount column
	 */	
	@Column(name = "amount")
	private BigDecimal amount;


	/**
	 * fromAccountId field for transfereeaccountid column
	 */	
	@Column(name = "transfereeaccountid")
	private Long fromAccountId;


	/**
	 * toAccountId field for id beneficiaryaccountid column
	 */	
	@Column(name = "beneficiaryaccountid")
	private Long toAccountId;

	public UserTransaction() {
	}

	/**
	 * @param currencyCode
	 * @param amount
	 * @param fromAccountId
	 * @param toAccountId
	 */
	public UserTransaction(String currencyCode, BigDecimal amount, Long fromAccountId, Long toAccountId) {
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

	/**
	 * @return transactionId
	 */
	public Long getTransactionId() {
		return transactionId;
	}

	
	/**
	 * @param transactionId
	 */
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @param currencyCode
	 */
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * @param amount
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @param fromAccountId
	 */
	public void setFromAccountId(Long fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	/**
	 * @param toAccountId
	 */
	public void setToAccountId(Long toAccountId) {
		this.toAccountId = toAccountId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		UserTransaction that = (UserTransaction) o;

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