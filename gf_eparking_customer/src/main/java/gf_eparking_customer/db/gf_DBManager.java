package gf_eparking_customer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class gf_DBManager {


private final String username = "root";	
private final String psw = "Campus02";
//private final String psw = "Gafu01011991";
private final String db = "gf_eparking_customer";
private final String driver = "com.mysql.jdbc.Driver";
	
	public Connection getConnection()
	{
		Connection con = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://109.73.158.173:3306/" + db,username,psw);
			//con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db,username,psw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public String SuccessConnection()
	{
		if(getConnection() == null)
		{
			return "Verbindung zur Datenbank nicht erfolgreich";
		}
		else
		{
			return "Verbindung zur Datenbank erfolgreich";
		}
	}

}
