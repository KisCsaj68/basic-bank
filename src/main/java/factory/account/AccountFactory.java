package factory.account;


import account.Account;
import customer.Customer;

public interface AccountFactory {
	Account createAccount(Customer customer);
}
