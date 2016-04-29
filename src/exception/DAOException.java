package exception;

@SuppressWarnings("serial")
public class DAOException extends Exception {

	public DAOException(){}
	public DAOException(Exception e){
        super(e);
    }
    public DAOException (String msg){
        super(msg);
    }
}
