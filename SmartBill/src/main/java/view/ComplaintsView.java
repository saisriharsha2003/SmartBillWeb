package view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.ComplaintModel;
import utility.Utility;

public class ComplaintsView {
	public static int registerComplaint(ComplaintModel cmp) throws ClassNotFoundException, SQLException
	{
		String s1 = "insert into complaint values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement p1 = Utility.getPreparedStatement(s1);
		p1.setInt(1, cmp.getComplaintId());
		p1.setLong(2, cmp.getConsumerNumber());
		p1.setString(3, cmp.getLandmark());
		p1.setString(4, cmp.getServiceType());
		p1.setString(5, cmp.getCategory());
		p1.setLong(6, cmp.getMobile());
		p1.setString(7, cmp.getContactPerson());
		p1.setString(8, cmp.getProlem());
		p1.setString(9, cmp.getAddress());
		p1.setString(10, "Not Solved");
		
		int res = p1.executeUpdate();
		return res;
	}
	
	public static List<HashMap<String, String>> fetchAllComplaints(int compid) throws ClassNotFoundException, SQLException
	{
		List<HashMap<String, String>> lm = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> mp1=new HashMap<String, String>();

		PreparedStatement p1 = Utility.getPreparedStatement("select * from complaint where complaint_id = ?");
		p1.setInt(1, compid);
		ResultSet rs = p1.executeQuery();
		while(rs.next())
		{
			mp1.put("complaint_id", String.valueOf(compid));
			mp1.put("contact_person", rs.getString("contact_person"));
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
			mp1.put("contact_person", rs.getString("contact_person"));
			mp1.put("mobile", rs.getString("mobile"));
			mp1.put("problem", rs.getString("problem"));
			mp1.put("address", rs.getString("address"));
			mp1.put("status", rs.getString("complaint_status"));
		}
		return mp1;
	}
	
	public static int fetchComplaintId(long cid) throws ClassNotFoundException, SQLException
	{
		PreparedStatement p1 = Utility.getPreparedStatement("select * from complaint where consumer_id = ?");
		p1.setLong(1, cid);
		ResultSet rs = p1.executeQuery();
		int compid = 0;
		while(rs.next())
		{
			compid = rs.getInt("complaint_id");
		}
		return compid;
	}

}
