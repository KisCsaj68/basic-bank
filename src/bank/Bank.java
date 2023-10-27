package bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.google.inject.Inject;

import account.Account;
import account.AccountType;
import customer.Customer;
import customer.CustomerType;
import factory.account.IAccountFactoryProvider;
import factory.customer.ICustomerFactoryProvider;

public class Bank {
	private Map<String, Customer> customers;
	private Map<UUID, Account> accounts;
	private final ICustomerFactoryProvider customerFactoryProvider;
	private final IAccountFactoryProvider accountFactoryProvider;

	@Inject
	public Bank(ICustomerFactoryProvider customerFactoryProvider, IAccountFactoryProvider accountFactoryProvider) {
		this.accounts = new HashMap<>();
		this.customers = new HashMap<>();
		this.customerFactoryProvider = customerFactoryProvider;
		this.accountFactoryProvider = accountFactoryProvider;
	}

	public Customer registerCustomer(String name, String customerAddress, String id, CustomerType type) {
		if (customers.containsKey(id)) {
			return customers.get(id);
		}
		Customer customer = customerFactoryProvider.getCustomerFactory(type).registerCustomer(name, customerAddress,
				id);
		customers.put(id, customer);
		return customer;

	}

	public UUID createAccount(Customer customer, AccountType type) {
		Account account = accountFactoryProvider.getAccountFactory(type).createAccount(customer);
		UUID accountNumber = account.getAccountNumber();
		accounts.put(accountNumber, account);
		return accountNumber;

	}

	public void cashDeposit(UUID accountNumber, long amount) {
		Optional<Account> optionalAccount = getAccount(accountNumber);
		if (optionalAccount.isEmpty()) {
			System.out.println(String.format("No account with number: %s", accountNumber));
			return;
		}
		Account account = optionalAccount.get();
		try {
			account.deposit(amount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void cashWithdraw(UUID accountNumber, long amount) {
		Optional<Account> optionalAccount = getAccount(accountNumber);
		if (optionalAccount.isEmpty()) {
			System.out.println(String.format("No account with number: %s", accountNumber));
			return;
		}
		Account account = optionalAccount.get();
		try {
			account.withdraw(amount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void cashTransfer(UUID fromAccount, UUID toAccount, long amount) {
		Optional<Account> optionalAccountTo = getAccount(toAccount);
		Optional<Account> optionalAccountFrom = getAccount(fromAccount);
		if (optionalAccountTo.isEmpty() && optionalAccountFrom.isEmpty()) {
			System.out.println(String.format("No account with number: %s", toAccount));
			System.out.println(String.format("No account with number: %s", fromAccount));
			return;
		}
		else if (optionalAccountTo.isEmpty()) {
			System.out.println(String.format("No account with number: %s", toAccount));
			return;
		}
		else if (optionalAccountFrom.isEmpty()) {
			System.out.println(String.format("No account with number: %s", fromAccount));
			return;
		}
		Account account = optionalAccountFrom.get();
		Account accountTo = optionalAccountTo.get();
		try {
			account.transfer(accountTo, amount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void accountHistory(UUID accountNumber) {
		Optional<Account> optionalAccount = getAccount(accountNumber);
		if (optionalAccount.isEmpty()) {
			System.out.println(String.format("No account with number: %s", accountNumber));
			return;
		}
		Account account = optionalAccount.get();
		account.getHistory();
	}
	
	private Optional<Account> getAccount(UUID accountNumber) {
		return Optional.ofNullable(accounts.get(accountNumber));
		
	}

}
