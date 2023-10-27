package factory.customer;

import customer.Customer;

public interface CustomerFactory {
	Customer registerCustomer(String name, String customerAddress, String id);

}
