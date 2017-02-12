package gf_eparking_customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class gf_NetworkUser {
	
@JsonProperty("Id")
private int Id;
@JsonProperty("UserName")
private String UserName;
@JsonProperty("FirstName")
private String FirstName;
@JsonProperty("LastName")
private String LastName;
@JsonProperty("Street")
private String Street;
@JsonProperty("StreetNr")
private int StreetNr;
@JsonProperty("PostCode")
private int PostCode;
@JsonProperty("City")
private String City;
@JsonProperty("Country")
private String Country;
@JsonProperty("Email")
private String Email;
@JsonProperty("CreditCardNr")
private int CreditCardNr;
@JsonProperty("ExpirationDate")
private String ExpirationDate;

public int getId() {
	return Id;
}


public void setId(int id) {
	Id = id;
}


public String getUserName() {
	return UserName;
}


public void setUserName(String userName) {
	UserName = userName;
}


public String getFirstName() {
	return FirstName;
}


public void setFirstName(String firstName) {
	FirstName = firstName;
}


public String getLastName() {
	return LastName;
}


public void setLastName(String lastName) {
	LastName = lastName;
}


public String getStreet() {
	return Street;
}


public void setStreet(String street) {
	Street = street;
}


public int getStreetNr() {
	return StreetNr;
}


public void setStreetNr(int streetNr) {
	StreetNr = streetNr;
}


public int getPostCode() {
	return PostCode;
}


public void setPostCode(int postCode) {
	PostCode = postCode;
}


public String getCity() {
	return City;
}


public void setCity(String city) {
	City = city;
}


public String getCountry() {
	return Country;
}


public void setCountry(String country) {
	Country = country;
}


public String getEmail() {
	return Email;
}


public void setEmail(String email) {
	Email = email;
}


public int getCreditCardNr() {
	return CreditCardNr;
}


public void setCreditCardNr(int creditCardNr) {
	CreditCardNr = creditCardNr;
}


public String getExpirationDate() {
	return ExpirationDate;
}


public void setExpirationDate(String expirationDate) {
	ExpirationDate = expirationDate;
}




public gf_NetworkUser()
{
}


	



}
