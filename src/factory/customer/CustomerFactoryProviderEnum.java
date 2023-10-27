package factory.customer;

import customer.CustomerType;

public enum CustomerFactoryProviderEnum implements ICustomerFactoryProvider{
	PERSON_FACTORY(CustomerType.PERSON, PersonFactory.INSTANCE),
	COMPANY_FACTORY(CustomerType.COMPANY, CompanyFactory.INSTANCE);

	private CustomerType type;
	private CustomerFactory factory;

	CustomerFactoryProviderEnum(CustomerType type, CustomerFactory factory) {
		this.type = type;
		this.factory = factory;
	}
	
	@Override
	public CustomerFactory getCustomerFactory(CustomerType type) {
		for (CustomerFactoryProviderEnum factory : values()) {
			if (factory.type == type) {
				return factory.factory;
			}
			
		}
		throw new RuntimeException(String.format("Unknown type: %s", type));
	}

}
