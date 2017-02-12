package gf_eparking_customer.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gf_eparking_customer.model.gf_Customer;

public class gf_customer_modify {

	public static void modify_Customer(gf_Customer customer) throws SQLException
	{
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;
	
		String updateTableSQL = "UPDATE customer SET titel = ?, formofAddress = ?, firstname = ?, lastname = ?, birthdate = ?, street = ?, plz = ?, city = ?, email = ?"
                + " WHERE customerNr = ?";

		try {
			gf_DBManager DBManager = new gf_DBManager();
			dbConnection = DBManager.getConnection();
			preparedStatement = dbConnection.prepareStatement(updateTableSQL);

			
			preparedStatement.setString(1, customer.getTitle());
			preparedStatement.setString(2, customer.getFormofAddress());
			preparedStatement.setString(3, customer.getFirstname());
			preparedStatement.setString(4, customer.getLastname());
			
			java.sql.Date date = new java.sql.Date(customer.getBirthdate().getTime());
			
			preparedStatement.setDate(5, date);
			preparedStatement.setString(6, customer.getStreet());
			preparedStatement.setString(7, customer.getPlz());
			preparedStatement.setString(8, customer.getCity());
			preparedStatement.setString(9, customer.getEmail());
			preparedStatement.setInt(10, customer.getCustomerNr());
			

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
