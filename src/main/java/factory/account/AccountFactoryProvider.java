package factory.account;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import account.AccountType;

public class AccountFactoryProvider implements IAccountFactoryProvider {
	private Map<AccountType, AccountFactory> provider;

	@Singleton
	public AccountFactoryProvider() {
		this.provider = new HashMap<>();
		this.provider.put(AccountType.CREDIT, CreditAccountFactory.INSTANCE);
		this.provider.put(AccountType.DEBIT, DebitAccountFactory.INSTANCE);
	}

	@Override
	public AccountFactory getAccountFactory(AccountType type) {
		return provider.get(type);
	}

}
