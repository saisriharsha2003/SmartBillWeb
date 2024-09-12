package view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import model.LoginModel;
import model.RegisterModel;
import utility.Utility;

public class LoginView {
	public static boolean authenticateAdmin(LoginModel lg) throws ClassNotFoundException, SQLException
	{
		String aun = lg.getUserName();
		String apwd = lg.getPassword();
		System.out.println(apwd);
		PreparedStatement p1 = Utility.getPreparedStatement("select * from admin_login where username = ?");
		p1.setString(1, "admin");
		ResultSet r1 = p1.executeQuery();
		String epwd = "";
		while(r1.next())
		{
			epwd = r1.getString("password");
		}
		System.out.println(epwd);
		if(apwd.equalsIgnoreCase(epwd))
		{
			return true;
		}
		return false;
	}
	
	public static boolean authenticateConsumer(LoginModel lg) throws ClassNotFoundException, SQLException
	{
		String aun = lg.getUserName();
		String apwd = lg.getPassword();
		PreparedStatement p1 = Utility.getPreparedStatement("select * from login where username = ?");
		p1.setString(1, aun);
		ResultSet r1 = p1.executeQuery();
		String epwd = "";
		while(r1.next())
		{
			epwd = r1.getString("password");
		}
		if(apwd.equalsIgnoreCase(epwd))
		{
			return true;
		}
		return false;
	}
	
	public static String fetchConsumerName(String uname) throws ClassNotFoundException, SQLException
	{
		PreparedStatement p2 = Utility.getPreparedStatement("select * from consumer where user_name = ?");
		p2.setString(1, uname);
		ResultSet rs = p2.executeQuery();
		String cname = "";
		while(rs.next())
		{
			cname = rs.getString("consumer_name");
		}
		return cname;
	}
	
	public static long fetchConsumerId(String uname) throws ClassNotFoundException, SQLException
	{
		PreparedStatement p2 = Utility.getPreparedStatement("select * from consumer where user_name = ?");
		p2.setString(1, uname);
		ResultSet rs = p2.executeQuery();
		long cid = 0;
		while(rs.next())
		{
			cid = rs.getLong("consumer_id");
		}
		return cid;
	}
	
	public static HashMap<String, String> fetchUserDetails(String uname) throws ClassNotFoundException, SQLException
	{
		HashMap<String, String> mp = new HashMap<>();
		String sql = "select * from consumer where user_name = ?";
		PreparedStatement p1 = Utility.getPreparedStatement(sql);
		p1.setString(1, uname);
		ResultSet rs = p1.executeQuery();
		if(rs.next())
		{
			mp.put("name", rs.getString("consumer_name"));
			mp.put("email", rs.getString("email"));
			mp.put("mobile", rs.getString("mobile").toString());
			mp.put("username", rs.getString("user_name"));
			mp.put("password", rs.getString("password"));
		}
		return mp;
	}
	
	public static int updateLoginDetails(String uname, String pwd) throws ClassNotFoundException, SQLException
	{
		PreparedStatement p1=Utility.getPreparedStatement("update login set username = ?, password = ?");
		p1.setString(1, uname);
		p1.setString(2, pwd);
		int res = p1.executeUpdate();
		return res;
	}
}
