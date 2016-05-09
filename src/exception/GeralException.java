package exception;

public class GeralException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GeralException() {
	}

	public GeralException(Exception e) {
		super(e);
	}

	public GeralException(String msg) {
		super(msg);
	}
}
