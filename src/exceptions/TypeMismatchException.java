package exceptions;

public class TypeMismatchException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TypeMismatchException(String errorMessage) {
		super(errorMessage);
	}
	
	public TypeMismatchException() {
		super();
	}

}
