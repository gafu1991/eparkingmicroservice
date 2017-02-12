package gf_eparking_customer.model;



public class gf_AuthentificationCustomer {


private int id;
private String authenticationToken;

public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getAuthenticationToken() {
	return authenticationToken;
}


public void setAuthenticationToken(String authenticationToken) {
	this.authenticationToken = authenticationToken;
}



public gf_AuthentificationCustomer(int id, String authenticationToken)
{
	this.id = id;
	this.authenticationToken = authenticationToken;
}



}
