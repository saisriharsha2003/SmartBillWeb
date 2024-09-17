package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import utility.Utility;

public class BillsLogic {
	public static List<HashMap<String, String>> fetchAllBills(long conid) throws ClassNotFoundException, SQLException, ParseException
	{
		AdminLogic.updatePenalty();
		List<HashMap<String, String>> lm = new ArrayList<HashMap<String, String>>();

		PreparedStatement p1 = Utility.getPreparedStatement("select * from bill where consumer_id = ?");
		p1.setLong(1, conid);
		ResultSet rs = p1.executeQuery();
		while(rs.next())
		{
			HashMap<String, String> mp1=new HashMap<String, String>();
			mp1.put("bill_id", String.valueOf(rs.getString("bill_number")));
			mp1.put("due_amt", String.valueOf(rs.getDouble("due_amount")));
			mp1.put("pay_amt", String.valueOf(rs.getDouble("bill_amount")));
			mp1.put("date", rs.getString("due_date"));
			mp1.put("penalty", String.valueOf(rs.getString("penalty")));
			mp1.put("status", rs.getString("status"));
			lm.add(mp1);
		}
		
		return lm;
	}
	
	public static List<HashMap<String, String>> fetchAllBillsPay(long conid) throws ClassNotFoundException, SQLException, ParseException
	{
		AdminLogic.updatePenalty();
		List<HashMap<String, String>> lm = new ArrayList<HashMap<String, String>>();

		PreparedStatement p1 = Utility.getPreparedStatement("select * from bill where consumer_id = ? and status != ? ");
		p1.setLong(1, conid);
		p1.setString(2, "Paid");
		ResultSet rs = p1.executeQuery();
		while(rs.next())
		{
			HashMap<String, String> mp1=new HashMap<String, String>();
			mp1.put("bill_id", String.valueOf(rs.getString("bill_number")));
			mp1.put("due_amt", String.valueOf(rs.getDouble("due_amount")));
			mp1.put("pay_amt", String.valueOf(rs.getDouble("bill_amount")));
			mp1.put("date", rs.getString("due_date"));
			mp1.put("penalty", String.valueOf(rs.getString("penalty")));
			mp1.put("status", rs.getString("status"));
			lm.add(mp1);
		}
		
		return lm;
	}
	
	public static HashMap<String, String> fetchPaymentBillDetails(int bill_id) throws SQLException, ClassNotFoundException
	{
		HashMap<String, String> m1= new HashMap<String, String>();
		
		PreparedStatement p1 = Utility.getPreparedStatement("select * from bill where bill_number = ?");
		p1.setInt(1, bill_id);
		ResultSet rs= p1.executeQuery();
		while(rs.next())
		{
			m1.put("bill_id", String.valueOf(rs.getInt("bill_number")));
			m1.put("due_amt", String.valueOf(rs.getDouble("due_amount")));
			m1.put("bill_amt", String.valueOf(rs.getDouble("bill_amount")));
			m1.put("penalty", String.valueOf(rs.getDouble("penalty")));
			m1.put("cons_id", String.valueOf(rs.getLong("consumer_id")));
		}
		return m1;
	}
	
	public static HashMap<String, String> fetchBillDetailsById(int bill_id) throws SQLException, ClassNotFoundException, ParseException
	{
		AdminLogic.updatePenalty();
		HashMap<String, String> m1= new HashMap<String, String>();
		
		PreparedStatement p1 = Utility.getPreparedStatement("select * from bill where bill_number = ?");
		p1.setInt(1, bill_id);
		ResultSet rs= p1.executeQuery();
		while(rs.next())
		{
			m1.put("bill_id", String.valueOf(rs.getInt("bill_number")));
			m1.put("due_amt", String.valueOf(rs.getDouble("due_amount")));
			m1.put("bill_amt", String.valueOf(rs.getDouble("bill_amount")));
			m1.put("due_date", String.valueOf(rs.getString("due_date")));
			m1.put("penalty", String.valueOf(rs.getDouble("penalty")));
			m1.put("status", String.valueOf(rs.getString("status")));
		}
		return m1;
	}
	
}
