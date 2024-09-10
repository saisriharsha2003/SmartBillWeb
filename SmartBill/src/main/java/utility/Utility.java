package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Utility {
	
	private static Statement st;
	private static PreparedStatement pst;

	
	public static Statement getStatement() throws SQLException, ClassNotFoundException
	{
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		String url = "jdbc:derby://localhost:1527/SaiDB";
		String uname = "sai2005";
		String pwd = "2035";
		Connection con = DriverManager.getConnection(url, uname, pwd);
		st = con.createStatement();
		return st;
	}
	
	public static PreparedStatement getPreparedStatement(String sql) throws SQLException, ClassNotFoundException
	{
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		String url = "jdbc:derby://localhost:1527/SaiDB";
		String uname = "sai2005";
		String pwd = "2035";
		Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/SaiDB", "sai2005", "2035");
		pst = con.prepareStatement(sql);
		return pst;
	}
	
	public static Connection getConnection1() throws ClassNotFoundException, SQLException
	{
		Class.forName("org.apache.derby.jdbc.ClientDriver");
		String url = "jdbc:derby://localhost:1527/SaiDB";
		String uname = "sai2005";
		String pwd = "2035";
		Connection con = DriverManager.getConnection(url, uname, pwd);
		return con;
	}
}
