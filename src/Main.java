import java.util.UUID;

import com.google.inject.Guice;
import com.google.inject.Injector;

import account.AccountType;
import bank.Bank;
import customer.Customer;
import customer.CustomerType;
import injector.AppInjector;

public class Main {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new AppInjector());
		Bank bank = injector.getInstance(Bank.class);
		Customer person = bank.registerCustomer("name", "adress", "SZIG1234", CustomerType.PERSON);
		Customer company = bank.registerCustomer("company", "adress", "VAT1234", CustomerType.COMPANY);
		UUID personCredit = bank.createAccount(person, AccountType.CREDIT);
		UUID personDebit = bank.createAccount(person, AccountType.DEBIT);
		UUID companyCredit = bank.createAccount(company, AccountType.CREDIT);
		UUID companyDebit = bank.createAccount(company, AccountType.DEBIT);
		bank.cashDeposit(companyDebit, 700);
		bank.cashWithdraw(companyDebit, 500);
		bank.cashTransfer(companyDebit, personDebit, 100);
		bank.cashWithdraw(companyCredit, 500);
		bank.cashWithdraw(personDebit, 20);
		bank.cashWithdraw(personCredit, 500);
		bank.accountHistory(companyDebit);
		System.out.println("------------");
		bank.accountHistory(companyCredit);
		System.out.println("------------");
		bank.accountHistory(personDebit);
		System.out.println("------------");
		bank.accountHistory(personCredit);
		
	}

}
