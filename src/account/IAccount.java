package account;

public interface IAccount {
	abstract void withdraw(long amount) throws Exception;
	default void transfer(Account to, long amount) throws Exception {
		withdraw(amount);
		to.deposit(amount);
	};
}
