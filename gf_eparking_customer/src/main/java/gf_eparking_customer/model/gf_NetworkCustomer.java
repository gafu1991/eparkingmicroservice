package gf_eparking_customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class gf_NetworkCustomer {

@JsonProperty("user")
private gf_NetworkUser user;
@JsonProperty("AuthenticationToken")
private String AuthentificationToken;
@JsonProperty("UserState")
private int Userstate;

public gf_NetworkUser getUser() {
	return user;
}





public void setUser(gf_NetworkUser user) {
	this.user = user;
}





public String getAuthentificationToken() {
	return AuthentificationToken;
}





public void setAuthentificationToken(String authentificationToken) {
	AuthentificationToken = authentificationToken;
}





public int getUserstate() {
	return Userstate;
}





public void setUserstate(int userstate) {
	Userstate = userstate;
}










public gf_NetworkCustomer()
{
	
}


	
	
}
