package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import model.BillModel;
import utility.Utility;

public class AdminLogic {
	public static int fetchCountConsumers() throws ClassNotFoundException, SQLException
	{
		Statement st = Utility.getStatement();
		ResultSet r1= st.executeQuery("select count(*) as cons_count from consumer");
		int c = 0;
		while(r1.next())
		{
			c=r1.getInt("cons_count");
		}
		return c;
		
	}
	
	public static int adminAddBill(BillModel bill) throws ClassNotFoundException, SQLException
	{
		String sql1 = "insert into bill values(?,?,?,?,?,?, ?)";
		PreparedStatement p1 = Utility.getPreparedStatement(sql1);
		p1.setInt(1, bill.getBillNuber());
		p1.setDouble(2, bill.getDueAmount());
		p1.setDouble(3, bill.getBillAmount());
		p1.setString(4, bill.getDueDate());
		p1.setDouble(5, bill.getPenalty());
		p1.setString(6, bill.getStatus());
		p1.setLong(7,  bill.getConsumerId());
		
		int res = p1.executeUpdate();
		return res;
	}
	
	public static List<HashMap<String, String>> fetchAllConsumers() throws ClassNotFoundException, SQLException
	{
		List<HashMap<String, String>> lh1=new ArrayList<HashMap<String, String>>();
		Statement p1 = Utility.getStatement();
		ResultSet rs= p1.executeQuery("select * from consumer");
		while(rs.next())
		{
			HashMap<String, String> h1=new HashMap<String, String>();
			h1.put("consumer_id", String.valueOf(rs.getLong("consumer_id")));
			h1.put("consumer_name", rs.getString("consumer_name"));
			h1.put("mobile", rs.getString("mobile"));
			h1.put("email", rs.getString("email"));
			h1.put("user_name", rs.getString("user_name"));
			lh1.add(h1);
		}
		return lh1;
	}
	
	public static class DateUtils {
	    public static String getTodayDate() {
	        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	        Date date = new Date();
	        return formatter.format(date);
	    }
	}
	
	public static int updatePenalty() throws ClassNotFoundException, SQLException, ParseException
	{
		String today = DateUtils.getTodayDate();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        String selectQuery = "SELECT * FROM bill ";
        
        PreparedStatement selectStmt = Utility.getPreparedStatement(selectQuery);
        ResultSet rs = selectStmt.executeQuery();
        
        int res = 0;

        while (rs.next()) {
            int billNumber = rs.getInt("bill_number");
            String dueDate = rs.getString("due_date");
            double bamt = rs.getDouble("bill_amount");
            double dueamt = rs.getDouble("due_amount");
            double pen = rs.getDouble("penalty");

            Date dueDateParsed = formatter.parse(dueDate);
            Date todayParsed = formatter.parse(today);
            
            if (dueDateParsed.before(todayParsed)) {
            	if(dueamt == bamt && pen>0)
            	{
            		String req1 = "UPDATE bill SET status = ? WHERE bill_number = ?";
                    PreparedStatement p1 = Utility.getPreparedStatement(req1);
                    p1.setString(1, "Overdue");
                    p1.setInt(2, billNumber);
                    res = p1.executeUpdate();
            	}
            	
                
                if(bamt == dueamt)
                {
                	String req = "update bill set penalty = ? where bill_number = ?";
                	PreparedStatement p2 = Utility.getPreparedStatement(req);
                    p2.setDouble(1, 100);
                    p2.setInt(2, billNumber);
                    res = p2.executeUpdate();
                }
                
            }
            
        }
        return res; 
	}
	public static List<HashMap<String, String>> fetchAllBillsAdmin() throws ClassNotFoundException, SQLException, ParseException
	{
		updatePenalty();
		List<HashMap<String, String>> lh1=new ArrayList<HashMap<String, String>>();
		Statement p1 = Utility.getStatement();
		ResultSet rs= p1.executeQuery("select * from bill");
		while(rs.next())
		{
			HashMap<String, String> h1=new HashMap<String, String>();
			h1.put("bill_id", String.valueOf(rs.getInt("bill_number")));
			h1.put("consumer_id", String.valueOf(rs.getLong("consumer_id")));
			h1.put("due_amount", String.valueOf(rs.getDouble("due_amount")));
			h1.put("pay_amount", String.valueOf(rs.getDouble("bill_amount")));
			h1.put("due_date", rs.getString("due_date"));
			h1.put("penalty", String.valueOf(rs.getDouble("penalty")));
			h1.put("status", rs.getString("status"));

			lh1.add(h1);
		}
		return lh1;
	}
	
	public static List<HashMap<String, String>> fetchAllComplaints() throws ClassNotFoundException, SQLException
	{
		List<HashMap<String, String>> lh1=new ArrayList<HashMap<String, String>>();
		PreparedStatement p1= Utility.getPreparedStatement("select * from complaint where complaint_status = ?");
		p1.setString(1, "Not Solved");
		ResultSet rs= p1.executeQuery();
		
		while(rs.next())
		{
			HashMap<String, String> h1=new HashMap<String, String>();
			h1.put("comp_no", String.valueOf(rs.getInt("complaint_id")));
			h1.put("cons_no", String.valueOf(rs.getLong("consumer_id")));
			h1.put("mobile", String.valueOf(rs.getLong("mobile")));
			h1.put("contact_per", rs.getString("contact"));
			h1.put("problem", rs.getString("problem"));
			h1.put("status", rs.getString("complaint_status"));

			lh1.add(h1);
		}
		return lh1;
	}
	
	public static int updateComplaint(int compid) throws ClassNotFoundException, SQLException
	{
		int r1 = 0;
		PreparedStatement p1= Utility.getPreparedStatement("update complaint set complaint_status = ? where complaint_id = ?");
		p1.setString(1, "Solved");
		p1.setInt(2, compid);
		r1 = p1.executeUpdate();
		return r1;
	}
	
	public static HashMap<String, String> fetchUpdatedComplaint(int cmpid) throws ClassNotFoundException, SQLException
	{
		HashMap<String, String> h1=new HashMap<String, String>();
		PreparedStatement p1 = Utility.getPreparedStatement("select * from complaint where complaint_id = ?");
		p1.setInt(1, cmpid);
		ResultSet rs= p1.executeQuery();
		while(rs.next())
		{
			h1.put("comp_no", String.valueOf(rs.getInt("complaint_id")));
			h1.put("cons_no", String.valueOf(rs.getLong("consumer_id")));
			h1.put("contact_per", rs.getString("contact"));
			h1.put("problem", rs.getString("problem"));
			h1.put("address", rs.getString("address"));

		}
		return h1;
		
	}
}
