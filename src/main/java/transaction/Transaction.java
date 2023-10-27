package transaction;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Transaction {
	private UUID id;
	private TransactionType type;
	private LocalDateTime date;
	private long amount;

	public Transaction(TransactionType type, long amount) {
		this.type = type;
		this.amount = amount;
		this.date = LocalDateTime.now();
		this.id = UUID.randomUUID();
	}

	@Override
	public String toString() {
		return "Transaction [type=" + type + ", date=" + date + ", amount="
				+ amount + "]";
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
		Transaction other = (Transaction) obj;
		return Objects.equals(id, other.id);
	}

}
