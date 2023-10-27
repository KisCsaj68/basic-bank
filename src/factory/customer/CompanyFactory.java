package factory.customer;

import customer.Company;
import customer.Customer;

public enum CompanyFactory implements CustomerFactory {
	INSTANCE;

	@Override
	public Customer registerCustomer(String name, String customerAddress, String id) {
		Customer customer = new Company(name, customerAddress, id);
		return customer;
	}

}
