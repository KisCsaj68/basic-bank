package injector;

import com.google.inject.AbstractModule;

import factory.account.AccountFactoryProvider;
import factory.account.IAccountFactoryProvider;
import factory.customer.CustomerFactoryProvider;
import factory.customer.ICustomerFactoryProvider;

public class AppInjector extends AbstractModule{

	@Override
	protected void configure() {
		bind(ICustomerFactoryProvider.class).to(CustomerFactoryProvider.class);
		bind(IAccountFactoryProvider.class).to(AccountFactoryProvider.class);
		
	}

}
