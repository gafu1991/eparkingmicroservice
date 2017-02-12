package gf_eparking_customer.model;

import java.sql.SQLException;
import java.util.ArrayList;


import com.fasterxml.jackson.annotation.JsonIgnore;

import gf_eparking_customer.db.gf_customer_delete;
import gf_eparking_customer.db.gf_customer_insert;
import gf_eparking_customer.db.gf_customer_modify;
import gf_eparking_customer.db.gf_customer_select;
import gf_eparking_customer.error.gf_Validation;
import gf_eparking_customer.exception.gf_CustomerDeleteException;
import gf_eparking_customer.exception.gf_DatabaseNoFoundException;


public class gf_Customer {

private int customerNr;
private String titel;
private String formofAddress;
private String firstname;
private String lastname;
private java.util.Date birthdate;

@JsonIgnore
private String birth;
private String street;
private String plz;
private String city;
private String email;

@JsonIgnore
private gf_Captcha captcha;

@JsonIgnore
private String agb;

@JsonIgnore
private ArrayList<gf_Customer> all_customer = new ArrayList<gf_Customer>();

@JsonIgnore
private ArrayList<gf_Customer> all_customer_von = new ArrayList<gf_Customer>();

@JsonIgnore
private String Fehlermeldung[][] = new String[12][2]; 

	
	public gf_Customer()
	{
		this.customerNr = setCustomerNr();
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
	
	@JsonIgnore
	public ArrayList<gf_Customer> get_all_Customer()
	{
		gf_customer_select.query_all_customer(this);
		
		
		return all_customer;
	}
	
	
	public ArrayList<gf_Customer> getCustomerfromto (int von, int bis)
	{
		
		all_customer_von.clear();
		for(gf_Customer customer : this.get_all_Customer())
		{
		//	System.out.println(customer.getCustomerNr() + " " + customer.getBirth());
			
			if(customer.getCustomerNr() >= von && customer.getCustomerNr() <= bis)
			{
				all_customer_von.add(customer);
			}
		}
		
		if(all_customer_von.size() <= 0)
		{
			throw new gf_DatabaseNoFoundException("Keinen Customer von Range " + von + " bis " + bis + " gefunden");
		}
			
		
		return all_customer_von;
	}
	
	public gf_Customer getCustomer(int id)
	{
		boolean find_customer = false;
		
		for(gf_Customer customer : this.get_all_Customer())
		{
		//	System.out.println(customer.getCustomerNr() + " " + customer.getBirth());
			
			if(customer.getCustomerNr() == id)
			{
				find_customer = true;
				return customer;
			}
		}
		
		if(!find_customer)
		{
			throw new gf_DatabaseNoFoundException("Customer with id " + id + " not  found");
		}
		
		return null;
		
	}
	
	
	@JsonIgnore
	public String getiwas()
	{
		return "Hallo";
	}
	
	@JsonIgnore
	public String[][] getFehlermeldung()
	{
		return Fehlermeldung;
	}
	
	
	public gf_Customer customer_modify(gf_Customer customer)
	{
		
		try {
		gf_customer_modify.modify_Customer(customer);
	
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return customer;
	}
	
	
	public void removeCustomer(int customerNr)
	{
		
		boolean customer_exception = false;
		
		if(gf_customer_select.customer_search(customerNr))
		{
			customer_exception = true;
		}
		else
		{
			customer_exception = false;
		}
		
		
		try
		{
		gf_customer_delete.deleteCustomer(customerNr);
			
		}catch(SQLException e)
		{
			e.getMessage();
		}
		
		
		if(customer_exception)
		{
			throw new gf_CustomerDeleteException("Customer " + customerNr + " wurde gelöscht");
		}
		else
		{
			throw new gf_DatabaseNoFoundException("Customer " + customerNr + " wurde nicht gefunden");	
		}
		
		
	}
	
	public gf_Customer customer_add(gf_Customer customer)
	{
		gf_Validation validate = new gf_Validation(customer);
		
		
		if(validate.checkAll())
		{
						try {
						gf_customer_insert.insert_Customer(customer);
						Fehlermeldung = validate.getErrorText();
						
						
						} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
						}
		}
		else
		{
			String fehlermeldungen = "";
			Fehlermeldung = validate.getErrorText();
			
			for (int i = 0; i < Fehlermeldung.length; i++)
			{
				if(Fehlermeldung[i][0] != "")
				{
				fehlermeldungen = fehlermeldungen + Fehlermeldung[i][0] + ", ";
				}
			}
				
			throw new gf_DatabaseNoFoundException(fehlermeldungen);
			
		}
	
			Fehlermeldung = validate.getErrorText();
		
			return customer;
		
				
		
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
	
@JsonIgnore
public String getAGB()
{
	return agb;
}

@JsonIgnore
public void setAGB(String agb)
{
	this.agb = agb;
}
	
	
public gf_Captcha getCaptcha()
{
	return captcha;
}

@JsonIgnore
public void setCaptcha(gf_Captcha captcha)
{
	this.captcha = captcha;
}
	
public String getBirth()
{
	return birth;
}

public void setBirthdate(java.util.Date birthdate) {
	this.birthdate = birthdate;
}


@JsonIgnore
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

@JsonIgnore
public void setCustomerNr(int customerNr)
{
	this.customerNr = customerNr;
}

@JsonIgnore
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



public java.util.Date getBirthdate() {
	return birthdate;
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
