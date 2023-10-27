package factory.customer;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Singleton;

import customer.CustomerType;

public class CustomerFactoryProvider implements ICustomerFactoryProvider {
	private Map<CustomerType, CustomerFactory> provider;

	@Singleton
	public CustomerFactoryProvider() {
		this.provider = new HashMap<>();
		this.provider.put(CustomerType.PERSON, PersonFactory.INSTANCE);
		this.provider.put(CustomerType.COMPANY, CompanyFactory.INSTANCE);
	}

	@Override
	public CustomerFactory getCustomerFactory(CustomerType type) {
		return provider.get(type);
	}

}
