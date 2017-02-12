package gf_eparking_customer.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class gf_ErrorCustomer {

	private String errorMessage;
	private int errorCode;
	private String documentation;
	
	public gf_ErrorCustomer()
	{
		
	}
	
	
	public gf_ErrorCustomer(String error_message, int error_code, String documentation)
	{
		super();
		this.errorMessage = error_message;
		this.errorCode = error_code;
		this.documentation = documentation;
	}
	
	@XmlElement public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	@XmlElement public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	@XmlElement public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
}
