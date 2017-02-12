package gf_eparking_registration_customer.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import gf_eparking_registration_customer.model.gf_Customer;

public class gf_customer_select {

	
	
	public static boolean customer_entry_exist()
	{
		gf_DBManager DBManager = new gf_DBManager();
		Connection con = null;
		boolean entry_exist = false;
		
		   try {
			   con = DBManager.getConnection();
	           Statement stmt = con.createStatement();
	            ResultSet rs;
	            
	            rs = stmt.executeQuery("SELECT * FROM customer");
	            if (rs.next() ) {
	              entry_exist = true;
	            }
	            con.close();
	        } catch (Exception e) {
	        	
	        	entry_exist = false;
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
		   
		  return entry_exist;
	}
	
	public static int last_entry_number()
	{
		gf_DBManager DBManager = new gf_DBManager();
		Connection con = null;
		int anzahl = 0;
		
		   try {
			   con = DBManager.getConnection();
	           Statement stmt = con.createStatement();
	            ResultSet rs;
	            
	            rs = stmt.executeQuery("SELECT MAX(customerNr) AS Nr FROM customer");
	            while ( rs.next() ) {
	             anzahl = rs.getInt("Nr");
	            }
	            con.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
		   
		   anzahl = anzahl + 1;
		   return anzahl;
	}
	
	

	public static void query_all_customer(gf_Customer gf_customer) {
		// TODO Auto-generated method stub
		gf_DBManager DBManager = new gf_DBManager();
		Connection con = null;
		
		   try {
			   con = DBManager.getConnection();
	           Statement stmt = con.createStatement();
	            ResultSet rs;
	 
	            gf_Customer customer = new gf_Customer();
	            
	            rs = stmt.executeQuery("SELECT * FROM customer");
	            while ( rs.next() ) {
	                customer.setCustomerNr(rs.getInt("customerNr"));
	                customer.setTitle(rs.getString("titel"));
	                customer.setFormofAddress(rs.getString("formofAddress"));
	                customer.setFirstname(rs.getString("firstname"));
	                customer.setLastname(rs.getString("lastname"));
	                customer.setBirthdate(rs.getDate("birthdate"));
	                customer.setStreet(rs.getString("street"));
	                customer.setPlz(rs.getString("plz"));
	                customer.setCity(rs.getString("city"));
	                customer.setEmail(rs.getString("email"));
	                
	               gf_customer.add_Customer(customer);
	            }
	            con.close();
	        } catch (Exception e) {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	        }
	}
}
