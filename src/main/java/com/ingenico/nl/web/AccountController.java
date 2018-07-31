package com.ingenico.nl.web;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ingenico.nl.Exception.CustomException;
import com.ingenico.nl.dto.AccountDTO;
import com.ingenico.nl.dto.MessageDTO;
import com.ingenico.nl.dto.UserTransactionDTO;
import com.ingenico.nl.service.AccountServiceImpl;

@RestController
@RequestMapping("/api/tasks")
public class AccountController {
	/**
	 * the accountServiceImpl
	 */
	@Autowired
	private AccountServiceImpl service;

	/**
	 * the messageSource
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * @param ex
	 * @return
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public MessageDTO handleValidationException(MethodArgumentNotValidException ex) {
		Locale locale = LocaleContextHolder.getLocale();
		String code = ex.getBindingResult().getFieldError().getDefaultMessage();
		return new MessageDTO(messageSource.getMessage(code, null, locale));
	}

	/**
	 * Create Account API
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public AccountDTO createAccount(@Valid @RequestBody AccountDTO dto) {
		return service.create(dto);
	}

	/**
	 * Find All Account API
	 * 
	 * @return
	 */
	@RequestMapping(value = "accounts", method = RequestMethod.GET)
	public List<AccountDTO> findAllAccounts() {

		List<AccountDTO> accountDTOs = service.findAllAccounts();

		return accountDTOs;

	}

	/**
	 * Transfer fund between two accounts.
	 * 
	 * @param transaction
	 * @return
	 * @throws CustomException
	 */
	@RequestMapping(value = "transfer", method = RequestMethod.POST)
	public UserTransactionDTO transferFund(@Valid @RequestBody UserTransactionDTO transaction) {
		UserTransactionDTO transactionData = null;
		String currency = transaction.getCurrencyCode();
		try {
			transactionData = service.transferAccountBalance(transaction);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return transactionData;

	}

}
