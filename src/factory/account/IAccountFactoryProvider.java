package factory.account;

import account.AccountType;

public interface IAccountFactoryProvider {

	AccountFactory getAccountFactory(AccountType type);

}
