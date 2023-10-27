package customer;

import java.util.Objects;

public class Company extends Customer{
	private String vatNumber;

	public Company(String name, String customerAddress, String vat) {
		super(name, customerAddress);
		this.vatNumber = vat;
	}
	
	public String getVatNumber() {
		return this.vatNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(vatNumber);
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
		Company other = (Company) obj;
		return Objects.equals(vatNumber, other.vatNumber);
	}

}
