package gf_eparking_customer.exception;

public class gf_DatabaseNoFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1447633089995235366L;

	
	public gf_DatabaseNoFoundException(String customer)
	{
		super(customer);
	}



}
