package factory.customer;

import customer.CustomerType;

public interface ICustomerFactoryProvider {
	CustomerFactory getCustomerFactory(CustomerType type);

}
