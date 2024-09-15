package view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		String ac_status ="";
		while(r1.next())
		{
			epwd = r1.getString("password");
			ac_status = r1.getString("status");
		}
		if (apwd.equals(epwd) && "Active".equalsIgnoreCase(ac_status)) {
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
	
	public static int updateLoginDetails(long cid, String uname, String pwd) throws ClassNotFoundException, SQLException
	{
		PreparedStatement p1=Utility.getPreparedStatement("update login set username = ?, password = ? where consumer_id = ?");
		p1.setString(1, uname);
		p1.setString(2, pwd);
		p1.setLong(3, cid);
		int res = p1.executeUpdate();
		return res;
	}
	
	public static boolean isUserExist(String username) throws ClassNotFoundException, SQLException
	{
		Statement p1 = Utility.getStatement();
		ResultSet r1= p1.executeQuery("select * from login");
		while(r1.next())
		{
			if(username.equalsIgnoreCase(r1.getString("username")))
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean fetchAccountStatus(String uname) throws ClassNotFoundException, SQLException
	{
		PreparedStatement p1= Utility.getPreparedStatement("select * from login where username = ?");
		p1.setString(1, uname);
		ResultSet r1= p1.executeQuery();
		while(r1.next())
		{
			if(r1.getString("status").equalsIgnoreCase("Active"))
			{
				return true;
			}
		}
		return false;
	}
	
	public static int softDeleteAccount(long conid) throws ClassNotFoundException, SQLException
	{
		PreparedStatement p1 = Utility.getPreparedStatement("update login set status = ? where consumer_id = ?");
		p1.setString(1, "Inactive");
		p1.setLong(2, conid);
		int res = p1.executeUpdate();
		return res;
	}
	
	public static int reactivateAccount(String uname) throws ClassNotFoundException, SQLException
	{
		PreparedStatement p1 = Utility.getPreparedStatement("update login set status = ? where username = ?");
		p1.setString(1, "Active");
		p1.setString(2, uname);
		int res = p1.executeUpdate();
		return res;
	}
	
	public static boolean reauthenticateConsumer(String uname, String pwd) throws ClassNotFoundException, SQLException
	{
		PreparedStatement p1 = Utility.getPreparedStatement("select * from login where username = ?");
		String epwd = "";
		p1.setString(1, uname);
		ResultSet r1= p1.executeQuery();
		while(r1.next())
		{
			epwd = r1.getString("password");
		}
		if(epwd.equalsIgnoreCase(pwd))
		{
			return true;
		}
		return false;
	}
}
