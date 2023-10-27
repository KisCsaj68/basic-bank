package factory.account;

import account.AccountType;

public enum AccountFactoryProviderEnum implements IAccountFactoryProvider {
	DEBIT_ACCOUNT_FACTORY(DebitAccountFactory.INSTANCE, AccountType.DEBIT),
	CREDIT_ACCOUNT_FACTORY(CreditAccountFactory.INSTANCE, AccountType.CREDIT);

	private AccountFactory accountFactory;
	private AccountType type;

	AccountFactoryProviderEnum(AccountFactory instance, AccountType type) {
		this.accountFactory = instance;
		this.type = type;
		
	}

	@Override
	public AccountFactory getAccountFactory(AccountType type) {
		for (AccountFactoryProviderEnum factory : values()) {
			if (factory.type == type) {
				return factory.accountFactory;
			}
			
		}
		throw new RuntimeException(String.format("Unknown type: %s", type));
	}
	
	
	
	
	

}
