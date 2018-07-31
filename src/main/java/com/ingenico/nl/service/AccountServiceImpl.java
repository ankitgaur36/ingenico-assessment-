package com.ingenico.nl.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ingenico.nl.Exception.CustomException;
import com.ingenico.nl.dto.AccountDTO;
import com.ingenico.nl.dto.UserTransactionDTO;
import com.ingenico.nl.entity.Account;
import com.ingenico.nl.entity.UserTransaction;
import com.ingenico.nl.repository.AccountRepository;
import com.ingenico.nl.repository.UserTransactionRepositry;

@Service
public class AccountServiceImpl {

	/**
	 * the accountRepository
	 */
	@Autowired
	private AccountRepository accountRepository;

	/**
	 * the transactionRepository
	 */
	@Autowired
	private UserTransactionRepositry transactionRepository;

	/**
	 * This method used to crate an account object
	 * 
	 * @param dto
	 * @return AccountDTO
	 */
	public AccountDTO create(AccountDTO dto) {
		Account account = new Account();
		this.saveAndUpdateAccount(dto, account);
		Account accountDeatils = accountRepository.saveAndFlush(account);
		return new AccountDTO(accountDeatils.getAccountId(), accountDeatils.getUserName(), accountDeatils.getBalance(),
				accountDeatils.getCurrencyCode());
	}

	/**
	 * This method used to set the parameter value
	 * 
	 * @param dto
	 * @param account
	 */
	private void saveAndUpdateAccount(AccountDTO dto, Account account) {
		account.setUserName(dto.getUserName());
		account.setCurrencyCode(dto.getCurrencyCode());
		account.setBalance(dto.getBalance());

	}

	/**
	 * This method used to update the account object
	 * 
	 * @param dto
	 * @param account
	 */
	public AccountDTO updateAccount(AccountDTO dto) {
		Account account = new Account();
		account.setAccountId(dto.getAccountId());
		this.saveAndUpdateAccount(dto, account);
		Account accountDeatils = accountRepository.saveAndFlush(account);
		return new AccountDTO(accountDeatils.getAccountId(), accountDeatils.getUserName(), accountDeatils.getBalance(),
				accountDeatils.getCurrencyCode());
	}

	/**
	 * To get the list of accounts
	 * 
	 * @return List<AccountDTO>
	 */
	public List<AccountDTO> findAllAccounts() {
		return accountRepository.findAll().stream().map(entity -> new AccountDTO(entity.getAccountId(),
				entity.getUserName(), entity.getBalance(), entity.getCurrencyCode())).collect(Collectors.toList());
	}

	/**
	 * To get the particular account from list
	 * 
	 * @param accountId
	 * @return AccountDTO
	 */
	public AccountDTO getAccountDetails(long accountId) {

		// If 'findAny' then return found If not found, return null
		return this.findAllAccounts().stream().filter(p -> p.getAccountId() == accountId).findAny().orElse(null);

	}

	/**
	 * Transfer balance between two accounts.
	 * 
	 * @param userTransactionDTO
	 * @return
	 * @throws CustomException
	 */
	public UserTransactionDTO transferAccountBalance(UserTransactionDTO userTransactionDTO) throws CustomException {

		AccountDTO fromAccount = null;
		AccountDTO toAccount = null;

		fromAccount = this.getAccountDetails(userTransactionDTO.getFromAccountId());
		toAccount = this.getAccountDetails(userTransactionDTO.getToAccountId());

		// check locking status
		if (fromAccount == null || toAccount == null) {
			throw new CustomException("Fail to lock both accounts for write");
		}

		// check transaction currency
		if (!fromAccount.getCurrencyCode().equals(userTransactionDTO.getCurrencyCode())) {
			throw new CustomException("Fail to transfer Fund, transaction ccy are different from source/destination");
		}

		// check ccy is the same for both accounts
		if (!fromAccount.getCurrencyCode().equals(toAccount.getCurrencyCode())) {
			throw new CustomException(
					"Fail to transfer Fund, the source and destination account are in different currency");
		}

		// check enough fund in source account
		BigDecimal fromAccountLeftOver = fromAccount.getBalance().subtract(userTransactionDTO.getAmount());

		// update account upon success locking
		BigDecimal balance = toAccount.getBalance().add(userTransactionDTO.getAmount());

		if (fromAccountLeftOver.compareTo(com.ingenico.nl.utils.Utils.zeroAmount) < 0) {
			throw new CustomException("Not enough Fund from source Account ");
		}
		// proceed with update

		// If there is no error, commit the transaction

		this.updateAccount(new AccountDTO(fromAccount.getAccountId(), fromAccount.getUserName(), fromAccountLeftOver,
				fromAccount.getCurrencyCode()));
		this.updateAccount(new AccountDTO(toAccount.getAccountId(), toAccount.getUserName(), balance,
				toAccount.getCurrencyCode()));

		UserTransaction userTransaction = new UserTransaction();

		BeanUtils.copyProperties(userTransactionDTO, userTransaction);

		UserTransaction transactionData = transactionRepository.saveAndFlush(userTransaction);
		BeanUtils.copyProperties(transactionData, userTransactionDTO);
		return userTransactionDTO;

	}

}
