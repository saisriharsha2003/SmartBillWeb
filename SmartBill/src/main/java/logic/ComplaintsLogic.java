package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.ComplaintModel;
import utility.Utility;

public class ComplaintsLogic {
	public static int registerComplaint(ComplaintModel cmp) throws ClassNotFoundException, SQLException
	{
		String s1 = "insert into complaint values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement p1 = Utility.getPreparedStatement(s1);
		p1.setInt(1, cmp.getComplaintId());
		p1.setString(2, cmp.getLandmark());
		p1.setString(3, cmp.getServiceType());
		p1.setString(4, cmp.getCategory());
		p1.setLong(5, cmp.getMobile());
		p1.setString(6, cmp.getContactPerson());
		p1.setString(7, cmp.getProlem());
		p1.setString(8, cmp.getAddress());
		p1.setString(9, "Not Solved");
		p1.setLong(10, cmp.getConsumerNumber());

		
		int res = p1.executeUpdate();
		return res;
	}
	
	public static List<HashMap<String, String>> fetchAllComplaints(long compid) throws ClassNotFoundException, SQLException
	{
		List<HashMap<String, String>> lm = new ArrayList<HashMap<String, String>>();

		PreparedStatement p1 = Utility.getPreparedStatement("select * from complaint where consumer_id = ?");
		p1.setLong(1, compid);
		ResultSet rs = p1.executeQuery();
		while(rs.next())
		{
			HashMap<String, String> mp1=new HashMap<String, String>();
			mp1.put("complaint_id", String.valueOf(rs.getString("complaint_id")));
			mp1.put("contact_person", rs.getString("contact"));
			mp1.put("mobile", rs.getString("mobile"));
			mp1.put("problem", rs.getString("problem"));
			mp1.put("address", rs.getString("address"));
			mp1.put("status", rs.getString("complaint_status"));
			lm.add(mp1);
		}
		
		return lm;
	}
	
	public static HashMap<String, String> fetchComplaintDetailsById(int compid) throws ClassNotFoundException, SQLException
	{
		HashMap<String, String> mp1=new HashMap<String, String>();
		PreparedStatement p1 = Utility.getPreparedStatement("select * from complaint where complaint_id = ?");
		p1.setInt(1, compid);
		ResultSet rs= p1.executeQuery();
		if(rs.next())
		{
			mp1.put("complaint_id", String.valueOf(compid));
			mp1.put("contact_person", rs.getString("contact"));
			mp1.put("mobile", rs.getString("mobile"));
			mp1.put("problem", rs.getString("problem"));
			mp1.put("address", rs.getString("address"));
			mp1.put("status", rs.getString("complaint_status"));
		}
		return mp1;
	}
	
	public static boolean isComplaintExist(int compid) throws ClassNotFoundException, SQLException
	{
		Statement s = Utility.getStatement();
		ResultSet rs = s.executeQuery("select * from complaint");
		while(rs.next())
		{
			if(rs.getInt("complaint_id") == compid)
			{
				return true;
			}
		}
		return false;
		
	}

}
