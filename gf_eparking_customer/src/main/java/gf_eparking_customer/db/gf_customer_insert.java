package gf_eparking_customer.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gf_eparking_customer.model.gf_Customer;

public class gf_customer_insert {

	public static void insert_Customer(gf_Customer customer) throws SQLException
	{
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String insertTableSQL = "INSERT INTO customer"
				+ "(customerNr, titel, formofAddress, firstname, lastname,birthdate,street,plz,city,email) VALUES"
				+ "(?,?,?,?,?,?,?,?,?,?)";
	
		try {
			gf_DBManager DBManager = new gf_DBManager();
			dbConnection = DBManager.getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);

			if(customer.getCustomerNr() == 0)
			{
				gf_Customer customertemp = new gf_Customer();
				
				customer.setCustomerNr(customertemp.setCustomerNr());
			}
			
			preparedStatement.setInt(1, customer.getCustomerNr());
			preparedStatement.setString(2, customer.getTitle());
			preparedStatement.setString(3, customer.getFormofAddress());
			preparedStatement.setString(4, customer.getFirstname());
			preparedStatement.setString(5, customer.getLastname());
			
			java.sql.Date date = new java.sql.Date(customer.getBirthdate().getTime());
			
			preparedStatement.setDate(6, date);
			preparedStatement.setString(7, customer.getStreet());
			preparedStatement.setString(8, customer.getPlz());
			preparedStatement.setString(9, customer.getCity());
			preparedStatement.setString(10, customer.getEmail());
			
			

			// execute insert SQL stetement
			preparedStatement.executeUpdate();

			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
}
