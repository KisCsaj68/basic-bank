package account;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import customer.Customer;
import exceptions.IllegalAmountException;
import exceptions.TypeMismatchException;
import transaction.Transaction;
import transaction.TransactionType;

public abstract class Account implements IAccount{
	private UUID accountNumber;
	private long balance;
	protected Set<Transaction> transactions;
	private AccountType type;
	private Customer holder;

	protected Account(AccountType type, Customer holder) {
		this.balance = 0l;
		this.transactions = new HashSet<>();
		this.accountNumber = UUID.randomUUID();
		this.type = type;
		this.holder = holder;
	}
	
	public final Customer getHolder() {
		return this.holder;
	}
	
	public final AccountType getType() {
		return this.type;
	}

	public  final long getBalance() {
		return balance;
	}

	public final void setBalance(long balance) {
		this.balance = balance;
	}

	public final UUID getAccountNumber() {
		return accountNumber;
	}
	
	public final void deposit(long amount) throws IllegalAmountException, TypeMismatchException{
		if (!checkAmount(amount)) {
			throw new IllegalAmountException("Amount cannot be 0 or negative.");
		}
		
		long newBalance = calculateNewBalance(amount, TransactionType.DEPOSIT);
		registerTransaction(amount, TransactionType.DEPOSIT);
		setBalance(newBalance);
		
	}
	
	public final boolean checkAmount(long amount){
		return amount > 0l;

	}
	
	public final boolean checkBalance(long amount) {
		return this.balance >= amount;
	}
	
	public final long calculateNewBalance(long amount, TransactionType type) throws TypeMismatchException{
		switch (type) {
		case DEPOSIT:
			return this.balance + amount;

		case WITHDRAW:
			return this.balance - amount;

		default:
			throw new TypeMismatchException(String.format("No transaction type found: %s", type));
		}
	}
	
	public final void registerTransaction(long amount, TransactionType type) {
		Transaction transaction = new Transaction(type, amount);
		this.transactions.add(transaction);
	}
	
	public final void getHistory() {
		for (Transaction t : transactions ) {
			System.out.println(t);
		}
	}

}
