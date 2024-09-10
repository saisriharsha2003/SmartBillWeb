package view;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import utility.Utility;
import model.RegisterModel;

public class RegisterView {
	
	public static int registerConsumer(RegisterModel reg) throws ClassNotFoundException, SQLException
	{
		
		String sql = "insert into consumer values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst = Utility.getPreparedStatement(sql);
		pst.setLong(1, reg.getConsumerId());
		pst.setString(2, reg.getTitle());
		pst.setString(3, reg.getName());
		pst.setString(4, reg.getEmail());
		pst.setLong(5, reg.getMobile());
		pst.setString(6, reg.getGender());
		pst.setString(7, reg.getUserName());
		pst.setString(8, reg.getPassword());
		
		String sql1 = "insert into login values(?,?,?)";
		PreparedStatement pst1 = Utility.getPreparedStatement(sql1);
		pst1.setString(1, reg.getUserName());
		pst1.setString(2, reg.getPassword());
		pst1.setLong(3, reg.getConsumerId());
		pst1.executeUpdate();
		
		int res = pst.executeUpdate();
		return res;
		
	}

}
