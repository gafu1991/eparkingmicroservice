package gf_eparking_customer_client;

public class gf_customer_social_customer {

private String username;
private String firstname;
private String lastname;
private String street;
private int streetNr;
public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}


public String getFirstname() {
	return firstname;
}


public void setFirstname(String firstname) {
	this.firstname = firstname;
}


public String getLastname() {
	return lastname;
}


public void setLastname(String lastname) {
	this.lastname = lastname;
}


public String getStreet() {
	return street;
}


public void setStreet(String street) {
	this.street = street;
}


public int getStreetNr() {
	return streetNr;
}


public void setStreetNr(int streetNr) {
	this.streetNr = streetNr;
}


public int getPostCode() {
	return postCode;
}


public void setPostCode(int postCode) {
	this.postCode = postCode;
}


public String getCity() {
	return city;
}


public void setCity(String city) {
	this.city = city;
}


public String getCountry() {
	return country;
}


public void setCountry(String country) {
	this.country = country;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public long getCreditnr() {
	return creditnr;
}


public void setCreditnr(long creditnr) {
	this.creditnr = creditnr;
}


public String getExpirationDate() {
	return ExpirationDate;
}


public void setExpirationDate(String expirationDate) {
	ExpirationDate = expirationDate;
}


private int postCode;
private String city;
private String country;
private String email;
private long creditnr;
private String ExpirationDate;


	public gf_customer_social_customer(String username, String firstname, String lastname, String street, int streetNr, int postCode, String city, String country, String email, long creditnr, String ExpirationDate)
	{
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.streetNr = streetNr;
		this.postCode = postCode;
		this.city = city;
		this.country = country;
		this.email = email;
		this.creditnr = creditnr;
		this.ExpirationDate = ExpirationDate;
		
	}
}
