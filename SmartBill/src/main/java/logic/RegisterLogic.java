package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.RegisterModel;
import utility.Utility;

public class RegisterLogic {
	
	public static int registerConsumer(RegisterModel reg) throws ClassNotFoundException, SQLException
	{
		
		String sql = "insert into consumer values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = Utility.getPreparedStatement(sql);
		pst.setLong(1, reg.getConsumerNumber());
		pst.setString(2, reg.getMeterNumber());
		pst.setString(3, reg.getTitle());
		pst.setString(4, reg.getName());
		pst.setString(5, reg.getEmail());
		pst.setLong(6, reg.getMobile());
		pst.setString(7, reg.getGender());
		pst.setString(8, reg.getUserName());
		pst.setString(9, reg.getPassword());
		int res = pst.executeUpdate();

		String sql1 = "insert into login values(?,?,?,?)";
		PreparedStatement pst1 = Utility.getPreparedStatement(sql1);
		pst1.setString(1, reg.getUserName());
		pst1.setString(2, reg.getPassword());
		pst1.setLong(3, reg.getConsumerNumber());
		pst1.setString(4, "Active");
		pst1.executeUpdate();
		
		return res;
		
	}
	
	public static int updateRegisterDetails(long cid, String name, String email, long mobile, String uname, String pwd) throws ClassNotFoundException, SQLException
	{
		PreparedStatement p1=Utility.getPreparedStatement("update consumer set consumer_name = ?, email = ?, mobile =?, user_name = ?, password = ? where consumer_id = ?");
		p1.setString(1, name);
		p1.setString(2, email);
		p1.setLong(3, mobile);
		p1.setString(4, uname);
		p1.setString(5, pwd);
		p1.setLong(6, cid);
		int res = p1.executeUpdate();
		return res;
	}
	
	public static boolean isAlreadyExist(RegisterModel reg) throws ClassNotFoundException, SQLException
	{
		Statement p1 = Utility.getStatement();
		ResultSet r1= p1.executeQuery("select * from consumer");
		while(r1.next())
		{
			if(reg.getUserName().equalsIgnoreCase(r1.getString("user_name")) || reg.getEmail().equalsIgnoreCase(r1.getString("email")))
			{
				return true;
			}
			
		}
		return false;
		
	}
	
	public static boolean isConsumerNumberFound(RegisterModel reg) throws ClassNotFoundException, SQLException
	{
		Statement p1 = Utility.getStatement();
		ResultSet r1 = p1.executeQuery("select * from consumer_details");
		while(r1.next())
		{
			if(reg.getConsumerNumber() == r1.getLong("consumer_number"))
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean isMeterNumberMatch(RegisterModel reg) throws ClassNotFoundException, SQLException
	{
		PreparedStatement p1 = Utility.getPreparedStatement("select * from consumer_details where consumer_number = ?");
		p1.setLong(1, reg.getConsumerNumber());
		
		ResultSet r1 = p1.executeQuery();
		while(r1.next())
		{
			if(r1.getString("meter_number").equalsIgnoreCase(reg.getMeterNumber()))
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean isConsumerNumberAlreadyExists(RegisterModel reg) throws ClassNotFoundException, SQLException
	{
		Statement p1 = Utility.getStatement();
		ResultSet r1 = p1.executeQuery("select * from consumer");
		while(r1.next())
		{
			if(reg.getConsumerNumber() == r1.getLong("consumer_id"))
			{
				return true;
			}
		}
		return false;
	}
	
	public static boolean isMeterNumberExists(RegisterModel reg) throws ClassNotFoundException, SQLException
	{
		Statement p1 = Utility.getStatement();
		ResultSet r1 = p1.executeQuery("select * from consumer");
		while(r1.next())
		{
			if(reg.getMeterNumber() == r1.getString("meter_number"))
			{
				return true;
			}
		}
		return false;
	}
}
