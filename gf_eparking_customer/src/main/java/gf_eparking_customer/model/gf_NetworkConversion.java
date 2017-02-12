package gf_eparking_customer.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class gf_NetworkConversion {
	
private String street;
private String plz;
private String [] street_array;
private int customerNr;
private String lastname;

	public gf_NetworkConversion(String street, String plz, int customerNr, String lastname)
	{
		this.street = street;
		this.plz = plz;
		this.customerNr = customerNr;
		this.lastname = lastname;
		this.street_array = street.split("\\s+");
	}
	
	
	String country = "Austria";
	
	
	public String getCountry()
	{
		return "Austria";
	}
	
	public int getCreditCardNumber()
	{
		return 890;
	}
	
	public String getUsername()
	{
		return customerNr + lastname;
	}
	
	public int getPlz()
	{
		 return Integer.parseInt(plz);	
	}
	
	
	public String getStreetName()
	{
		String street_concat = "";
		
		for (int i = 0; i < street_array.length -1 ; i++)
		{
			street_concat = street_concat + street_array[i];
		}
		return street_concat;
		
	}
	
	public int getStreetNumber()
	{
		
		int street_nr;
		
		try
		{
		street_nr = Integer.parseInt(street_array[street_array.length-1]);
		}
		catch(NumberFormatException e)
		{
			street_nr = 0;
		}
		
		return street_nr;
	}
	
	public String getAblaufdatum()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2019);
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		cal.set(Calendar.DAY_OF_MONTH, 1);

		java.util.Date ablaufdatum = cal.getTime();
		java.text.SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		
		
		return format1.format(ablaufdatum); 
		
	}

}
