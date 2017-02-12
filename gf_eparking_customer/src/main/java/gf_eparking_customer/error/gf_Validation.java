package gf_eparking_customer.error;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import gf_eparking_customer.model.gf_Customer;
import nl.captcha.Captcha;
import gf_eparking_customer.db.gf_customer_select;
import gf_eparking_customer.exception.gf_DatabaseNoFoundException;

public class gf_Validation {

private gf_Customer customer;
private String error_text[][] = new String[12][2];
public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);



	
public gf_Validation(gf_Customer customer)
{
	setCustomer(customer);
}


public gf_Customer getCustomer() 
{
	return customer;
}

public void setCustomer(gf_Customer customer)
{	
	this.customer = customer;
}

public boolean checkAll()
{
	if(checkFormofAddress() & checktitle() & checkfirstName() & checklastName() & checkbirthdate() & checkstreet() & checkplz() & checkcity() & checkemail() & checkCustomerNotExist() & checkCaptcha() & checkAGB())
	{
		return true;
	}
	
	return false;
}

public String[][] getErrorText()
{
	return error_text;
}

private boolean checkFormofAddress()
{
	String fehlermeldung = "";
	error_text[0][0] = "";
	error_text[0][1] = customer.getFormofAddress();
	
	
	if(customer.getFormofAddress().equals(""))
	{
		fehlermeldung = "Anrede darf nicht leer sein";
		error_text[0][0] = fehlermeldung;
		error_text[0][1] = "";
		return false;
	}
	


	return true;
}

private boolean checktitle()
{
	error_text[1][0] = "";
	error_text[1][1] = customer.getTitle();
	return true;
}


private boolean checkfirstName()
{
	String fehlermeldung = "";
	error_text[2][0] = "";
	error_text[2][1] = customer.getFirstname();
	
	if(customer.getFirstname().equals(""))
	{
		fehlermeldung = "Vorname darf nicht leer sein";
		error_text[2][0] = fehlermeldung;
		error_text[2][1] = "";
		return false;
	}
	


	return true;
}

private boolean checklastName()
{
	String fehlermeldung = "";
	error_text[3][0] = "";
	error_text[3][1] = customer.getLastname();
	
	if(customer.getLastname().equals(""))
	{
		fehlermeldung = "Nachname darf nicht leer sein";
		error_text[3][0] = fehlermeldung;	
		error_text[3][1] = "";
		return false;
	}
	
	
	
	return true;
}

private boolean checkbirthdate()
{
	StringBuilder fehlermeldung = new StringBuilder();
	boolean check = true;
	Calendar cal = Calendar.getInstance();
	
	java.util.Date date_now = new java.util.Date();
	Calendar cal_now = Calendar.getInstance();
	cal_now.setTime(date_now);
	
	java.util.Date date = null;
	
	error_text[4][0] = "";
	error_text[4][1] = customer.getBirth();
	
	
	if(customer.getBirth() == null)
	{
		return true;
	}
	
	
	if(customer.getBirth().equals(""))
	{
		fehlermeldung.append("Geburtstag darf nicht leer sein ");
		check = false;
		error_text[4][1] = "";
	}
	
	
	
	try {
		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		date = formatter.parse(customer.getBirth());
		System.out.println(date);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		customer.setBirth(sqlDate);
	
	} catch (ParseException exp) {
		try
		{
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		date = formatter.parse(customer.getBirth());
		System.out.println(date);
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		customer.setBirth(sqlDate);
		}
		catch (ParseException exp2)
		{
		    exp2.printStackTrace();
		    fehlermeldung.append("Bitte Datum in folgenden Format eingeben : dd.MM.yyyy");
		    check = false;
		    error_text[4][1] = "";
		}
		

	}
	
	if(check)
	{
		check = check_if_eighteen(cal_now,cal,fehlermeldung,date);
	}

	error_text[4][0] = fehlermeldung.toString();
	
	return check;
}



private boolean check_if_eighteen(Calendar cal_now, Calendar cal, StringBuilder fehlermeldung, java.util.Date date)
{
	cal.setTime(date);
	boolean check = true;
	
	if((cal_now.get(Calendar.YEAR) - cal.get(Calendar.YEAR)) < 17)
	{
		check = false;
		fehlermeldung.append("Sie müssen 17 sein");
		error_text[4][1] = "";
	}
	else if((cal_now.get(Calendar.YEAR) - cal.get(Calendar.YEAR)) == 17)
	{
		if(cal.get(Calendar.MONTH) > cal_now.get(Calendar.MONTH))
		{
			check = false;
			fehlermeldung.append("Sie müssen 17 sein");
			error_text[4][1] = "";
		}
		else if(cal.get(Calendar.MONTH) == cal_now.get(Calendar.MONTH))
		{
			if(cal.get(Calendar.DAY_OF_MONTH) > cal_now.get(Calendar.DAY_OF_MONTH))
			{
			check = false;
			fehlermeldung.append("Sie müssen 17 sein");
			error_text[4][1] = "";
			}
		}
	}
	
	return check;
}




private boolean checkstreet()
{
	String fehlermeldung = "";
	int street_nr = 0;
	String street_array[];
	error_text[5][0] = "";
	error_text[5][1] = customer.getStreet();
	boolean check = true;
	
	if(customer.getStreet().equals(""))
	{
		fehlermeldung = "Straße darf nicht leer sein";
			
		
		check = false;
		error_text[5][1] = "";
		
	}
	
	street_array = customer.getStreet().split("\\s+");
	
	try
	{
	street_nr = Integer.parseInt(street_array[street_array.length-1]);
	
	}
	catch(NumberFormatException e)
	{
		fehlermeldung = fehlermeldung +  "Geben Sie eine Hausnummer ein";
		check = false;
		error_text[5][1] = "";
	}	
	
	
	error_text[5][0] = fehlermeldung;
	
	return check;
}

private boolean checkplz()
{
	String fehlermeldung = "";
	boolean check = true;
	
	int length = customer.getPlz().length();
	error_text[6][0] = "";
	error_text[6][1] = customer.getPlz();
	
	if(length != 4)
	{
		fehlermeldung = "PLZ muss aus 4 Zahlen bestehen ";
		check = false;
		error_text[6][1] = "";
	}
	
	
	if(customer.getPlz().equals(""))
	{
		fehlermeldung = fehlermeldung + "PLZ darf nicht leer sein";
		check = false;
		error_text[6][1] = "";
	}
	
	error_text[6][0] = fehlermeldung;
	
	return check;
}

private boolean checkcity()
{
	String fehlermeldung = "";
	error_text[7][0] = "";
	
	
	if(customer.getCity().equals(""))
	{
		fehlermeldung = "Ort darf nicht leer sein";
		error_text[7][0] = fehlermeldung;
		error_text[7][1] = "";
		return false;
	}
	
	
	error_text[7][1] = customer.getCity();
	return true;
}

private boolean checkemail()
{
	String fehlermeldung = "";
	boolean check = true;
	
	error_text[8][0] = "";
	error_text[8][1] = customer.getEmail();
	Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(customer.getEmail());
	
	if(!matcher.find())
	{
		fehlermeldung = "Falsches E-Mail Format ";
		check = false;
		error_text[8][1] = "";
	}
	
	if(customer.getEmail().equals(""))
	{
		fehlermeldung = fehlermeldung +  "E-Mail darf nicht leer sein";
		check = false;
		error_text[8][1] = "";
	}
	
	error_text[8][0] = fehlermeldung;

	
	
	return check;
}


private boolean checkCaptcha()
{
	error_text[10][0] = "";
	error_text[10][1] = "";
	
	boolean check = true;
	
	
	if(customer.getCaptcha() == null)
	{
		return true;
	}
	
	if(!customer.getCaptcha().getSession().isCorrect(customer.getCaptcha().getCaptcha()))
	{
		check = false;
		error_text[10][0] = "Captcha-Eingabe ist falsch";
	}
	
	
	return check;
}

private boolean checkAGB()
{
	error_text[11][0] = "";
	error_text[11][1] = "";
	boolean check = true;
	
	if(customer.getAGB() == null)
	{
		return true;
	}
	
	if(!customer.getAGB().equals("on"))
	{
		check = false;
		error_text[11][1] = "Akzeptieren Sie die AGB";
	}
	
	
	return check;
}


private boolean checkCustomerNotExist()
{
	
boolean checkCustomer = true;
error_text[9][0] = "";
error_text[9][1] = "";


for(gf_Customer get_customer : customer.get_all_Customer())
{
	System.out.println(get_customer.getFirstname());
	
	if(get_customer.getFirstname().equals(customer.getFirstname()))
	{
		if(get_customer.getLastname().equals(customer.getLastname()))
		{
			if(get_customer.getBirthdate().equals(customer.getBirthdate()))
			{
				if(get_customer.getEmail().equals(customer.getEmail()))
				{
					checkCustomer = false;
					error_text[9][0] = "Customer schon angelegt";
				}
			}
		}
	}
}


return checkCustomer;
	
	
}
	

	
	
}
