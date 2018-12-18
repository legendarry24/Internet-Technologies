package ua.nure.sherbakov.practice7.server.dao;

@SuppressWarnings("serial")
public class DAOException extends Exception {
	public DAOException() {
		super();
	}

	public DAOException(String msg) {
		super(msg);
	}

	public DAOException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}
}
