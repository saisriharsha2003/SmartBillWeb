package view;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.ComplaintModel;
import utility.Utility;

public class ComplaintView {
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
	

}
