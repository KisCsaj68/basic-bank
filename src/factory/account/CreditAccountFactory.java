package factory.account;

import account.Account;
import account.CreditAccount;
import customer.Customer;

public enum CreditAccountFactory implements AccountFactory {
	INSTANCE;
	private static long BASE_CREDIT = 1000l;

	@Override
	public Account createAccount(Customer customer) {
		return new CreditAccount(BASE_CREDIT, customer);
	}

}
