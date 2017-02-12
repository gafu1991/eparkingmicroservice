package gf_eparking_customer.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gf_eparking_customer.model.gf_Customer;

public class gf_customer_delete {

	
public static void deleteCustomer(int customerNr) throws SQLException
{
	Connection dbConnection = null;
	PreparedStatement preparedStatement = null;

	String deleteSQL = "DELETE FROM customer WHERE customerNr = ?";

	try {

		gf_DBManager DBManager = new gf_DBManager();
		dbConnection = DBManager.getConnection();
		preparedStatement = dbConnection.prepareStatement(deleteSQL);
		
		preparedStatement.setInt(1, customerNr);

		// execute delete SQL stetement
		preparedStatement.executeUpdate();

		System.out.println("Record is deleted!");

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
