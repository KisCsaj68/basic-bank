package account;

import customer.Customer;
import exceptions.IllegalAmountException;
import exceptions.InsufficientFundsException;
import transaction.TransactionType;

public class CreditAccount extends Account {
	private long credit;

	public CreditAccount(long credit, Customer holder) {
		super(AccountType.CREDIT, holder);
		this.credit = credit;
	}

	@Override
	public void withdraw(long amount) throws Exception {
		if (!checkAmount(amount)) {
			throw new IllegalAmountException("Amount cannot be 0 or negative.");
		}

		if (checkBalance(amount)) {
			long newBalance = calculateNewBalance(amount, TransactionType.WITHDRAW);
			registerTransaction(amount, TransactionType.WITHDRAW);
			setBalance(newBalance);
			return;
		}

		if (credit < amount) {
			throw new InsufficientFundsException("There is no funds in your account!");
		}
		registerTransaction(amount, TransactionType.WITHDRAW);
		this.credit = this.credit - amount;

	}

}
