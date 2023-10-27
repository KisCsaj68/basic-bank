package customer;

import java.util.Objects;

public class Person extends Customer{
	private String personalNumber;

	public Person(String name, String customerAddress, String personalNumber) {
		super(name, customerAddress);
		this.personalNumber = personalNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(personalNumber);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(personalNumber, other.personalNumber);
	}
	
	

}
