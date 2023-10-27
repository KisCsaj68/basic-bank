package bank;

import java.util.HashMap;
import java.util.Map;
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
//	private String addresss;
	private final ICustomerFactoryProvider customerFactoryProvider;
	private final IAccountFactoryProvider accountFactoryProvider;

	@Inject
	public Bank(ICustomerFactoryProvider customerFactoryProvider,
			IAccountFactoryProvider accountFactoryProvider) {
		this.accounts = new HashMap<>();
		this.customers = new HashMap<>();
//		this.setAddresss(bankAddress);
		this.customerFactoryProvider = customerFactoryProvider;
		this.accountFactoryProvider = accountFactoryProvider;
	}

	public Customer registerCustomer(String name, String customerAddress, String id, CustomerType type) {
		if (customers.containsKey(id)) {
			return customers.get(id);
		}
		Customer customer = customerFactoryProvider.getCustomerFactory(type).registerCustomer(name, customerAddress, id);
		customers.put(id, customer);
		return customer;

	}

	public UUID createAccount(Customer customer, AccountType type) {
		Account account = accountFactoryProvider.getAccountFactory(type).createAccount(customer);
		UUID accountNumber = account.getAccountNumber();
		accounts.put(accountNumber, account);
		return accountNumber;

	}
//TODO handle exception when there is no key in the map!
	public void cashDeposit(UUID accountNumber, long amount) {
		Account account = accounts.get(accountNumber);
		try {
			((Account) account).deposit(amount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void cashWithdraw(UUID accountNumber, long amount) {
		Account account = accounts.get(accountNumber);
		try {
			account.withdraw(amount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public void cashTransfer(UUID fromAccount, UUID toAccount, long amount) {
		Account account = accounts.get(fromAccount);
		Account accountTo = accounts.get(toAccount);
		try {
			account.transfer(accountTo, amount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void accountHistory(UUID accountNumber) {
		Account account = accounts.get(accountNumber);
		account.getHistory();
	}

//	public String getAddresss() {
//		return addresss;
//	}
//
//	public void setAddresss(String addresss) {
//		this.addresss = addresss;
//	}

}
