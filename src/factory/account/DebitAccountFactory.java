package factory.account;


import account.Account;
import account.DebitAccount;
import customer.Customer;

public enum DebitAccountFactory implements AccountFactory {
	INSTANCE;

	@Override
	public Account createAccount(Customer customer) {
		return new DebitAccount(customer);
	}



}
