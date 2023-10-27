package exceptions;

public class InsufficientFundsException extends RuntimeException{

	private static final long serialVersionUID = -4951721617151705345L;

	public InsufficientFundsException(String errorMessage) {
		super(errorMessage);
	}
	
	public InsufficientFundsException() {
		super();
	}


}
