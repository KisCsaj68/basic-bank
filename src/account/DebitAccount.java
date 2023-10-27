package account;

import customer.Customer;
import exceptions.IllegalAmountException;
import exceptions.InsufficientFundsException;
import transaction.TransactionType;

public class DebitAccount extends Account {

	public DebitAccount(Customer holder) {
		super(AccountType.DEBIT, holder);
	}

	@Override
	public void withdraw(long amount) throws Exception {
		long newBalance = calculateNewBalance(amount, TransactionType.WITHDRAW);
		if (!checkAmount(amount)) {
			throw new IllegalAmountException("Amount cannot be 0 or negative.");

		}
		if (!checkBalance(amount)) {
			throw new InsufficientFundsException("There is no funds in your account!");
		}
		registerTransaction(amount, TransactionType.WITHDRAW);
		setBalance(newBalance);

	}

}
