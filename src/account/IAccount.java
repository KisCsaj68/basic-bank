package account;

import exceptions.IllegalAmountException;
import exceptions.InsufficientFundsException;
import exceptions.TypeMismatchException;

public interface IAccount {
	abstract void withdraw(long amount) throws IllegalAmountException, TypeMismatchException, InsufficientFundsException;
	default void transfer(Account to, long amount) throws IllegalAmountException, TypeMismatchException, InsufficientFundsException {
		withdraw(amount);
		to.deposit(amount);
	};
}
