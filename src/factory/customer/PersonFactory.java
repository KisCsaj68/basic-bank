package factory.customer;

import customer.Customer;
import customer.Person;

public enum PersonFactory implements CustomerFactory {
	INSTANCE;

	@Override
	public Customer registerCustomer(String name, String customerAddress, String id) {
		Customer customer = new Person(name, customerAddress, id);
		return customer;
	}

}
