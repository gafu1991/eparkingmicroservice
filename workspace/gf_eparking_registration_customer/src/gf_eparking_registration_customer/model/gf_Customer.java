package gf_eparking_registration_customer.model;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;


import gf_eparking_registration_customer.db.gf_customer_insert;
import gf_eparking_registration_customer.db.gf_customer_select;
import gf_eparking_registration_customer.error.gf_Validation;

public class gf_Customer {

private int customerNr;
private String titel;
private String formofAddress;
private String firstname;
private String lastname;
private Date birthdate;
private String birth;
private String street;
private String plz;
private String city;
private String email;
private gf_Captcha captcha;
private String agb;
private ArrayList<gf_Customer> all_customer = new ArrayList<gf_Customer>();
private String Fehlermeldung[][] = new String[12][2]; 

	
	public gf_Customer()
	{
		
	}

	
	public gf_Customer(String titel, String formofAddress, String firstname, String lastname, String birthdate, String street, String plz, String city, String email, gf_Captcha captcha, String agb)
	{
		
		this.customerNr = setCustomerNr();
		this.titel = titel;
		this.formofAddress = formofAddress;
		this.firstname = firstname;
		this.lastname = lastname;
		this.birth = birthdate;
		this.street = street;
		this.plz = plz;
		this.city = city;
		this.email = email;
		this.captcha = captcha;
		this.agb = agb;
	}
	
	
	
	
	public void add_Customer(gf_Customer customer)
	{
		all_customer.add(customer);
	}
	
	public ArrayList<gf_Customer> get_all_Customer()
	{
		gf_customer_select.query_all_customer(this);
		return all_customer;
	}
	
	
	public String getiwas()
	{
		return "Hallo";
	}
	
	public String[][] getFehlermeldung()
	{
		return Fehlermeldung;
	}
	
	public boolean InsertCustomer_afterallChecks(gf_Customer customer)
	{
		gf_Validation validate = new gf_Validation(customer);
		
		
		if(validate.checkAll())
		{
						try {
						gf_customer_insert.insert_Customer(customer);
						Fehlermeldung = validate.getErrorText();
						return true;
						} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
		}
	
			Fehlermeldung = validate.getErrorText();
		
			return false;
		
				
		
	}
	

public String getAGB()
{
	return agb;
}

public void setAGB(String agb)
{
	this.agb = agb;
}
	
	
public gf_Captcha getCaptcha()
{
	return captcha;
}

public void setCaptcha(gf_Captcha captcha)
{
	this.captcha = captcha;
}
	
public String getBirth()
{
	return birth;
}

public void setBirth(java.sql.Date birth)
{
	this.birthdate = birth;
}

	
public String getTitle()
{
	return titel;
}
	
public void setTitle(String titel)
{
	this.titel = titel;
}


public String getCity()
{
	return city;
}

public void setCity(String city)
{
	this.city = city;
}

public int getCustomerNr() {
	return customerNr;
}

public void setCustomerNr(int customerNr)
{
	this.customerNr = customerNr;
}


public int setCustomerNr() {
	
int customer_nr = 0;	
	
	if(!gf_customer_select.customer_entry_exist())
	{
		customer_nr = 10000;
	}
	else
	{
		customer_nr = gf_customer_select.last_entry_number();
	}

	return customer_nr;
	
	
}



public String getFormofAddress() {
	return formofAddress;
}



public void setFormofAddress(String formofAddress) {
	this.formofAddress = formofAddress;
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



public Date getBirthdate() {
	return birthdate;
}



public void setBirthdate(Date birthdate) {
	this.birthdate = birthdate;
}



public String getStreet() {
	return street;
}



public void setStreet(String street) {
	this.street = street;
}



public String getPlz() {
	return plz;
}



public void setPlz(String plz) {
	this.plz = plz;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}




	
}
