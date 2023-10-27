package customer;

import java.util.Objects;
import java.util.UUID;

public class Customer {
	private String name;
	private String address;
	private UUID id;

	public Customer(String name, String customerAddress) {
		this.address = customerAddress;
		this.name = name;
		this.id = UUID.randomUUID();
	}

	public String getAddress() {
		return this.address;
	}

	public String getName() {
		return this.name;
	}

	public UUID getId() {
		return this.id;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public void setAddress(String newAddress) {
		this.address = newAddress;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id);
	}

}
