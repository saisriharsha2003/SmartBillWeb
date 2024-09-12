package view;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Bill;
import utility.Utility;

public class AdminView {
	public static int adminAddBill(Bill bill) throws ClassNotFoundException, SQLException
	{
		String sql1 = "insert into bill values(?,?,?,?,?,?)";
		PreparedStatement p1 = Utility.getPreparedStatement(sql1);
		p1.setInt(1, bill.getBillNuber());
		p1.setDouble(2, bill.getDueAmount());
		p1.setDouble(3, bill.getPayableAmount());
		p1.setString(4, bill.getDueDate());
		p1.setString(5, bill.getStatus());
		p1.setLong(6,  bill.getConsumerId());
		
		int res = p1.executeUpdate();
		return res;
	}
}
