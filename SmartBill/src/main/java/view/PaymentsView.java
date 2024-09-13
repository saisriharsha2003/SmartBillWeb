package view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.PaymentModel;
import utility.Utility;

public class PaymentsView {
	public static int makePayment(PaymentModel pm) throws ClassNotFoundException, SQLException, ParseException {
	    PreparedStatement p1 = Utility.getPreparedStatement("insert into payment values(?,?,?,?,?)");
	    p1.setInt(1, pm.getTransactionNumber());
	    p1.setInt(2, pm.getBillNumber());
	    p1.setDouble(3, pm.getPaidAmount());
	    p1.setString(4, pm.getTransactionMode());
	    p1.setString(5, pm.getTransactionDate());  
	    int res = p1.executeUpdate();

	    PreparedStatement p2 = Utility.getPreparedStatement("select * from bill where bill_number = ?");
	    p2.setInt(1, pm.getBillNumber());
	    ResultSet rs = p2.executeQuery();
	    
	    double bamt = 0;
	    double edamt = 0;
	    String dueDate = "";  
	    while (rs.next()) {
	        bamt = rs.getDouble("bill_amount");
	        edamt = rs.getDouble("due_amount");
	        dueDate = rs.getString("due_date");  
	    }

	    String nstatus = "";
	    double t1 = edamt - pm.getPaidAmount() ;
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date transactionDate = sdf.parse(pm.getTransactionDate());
        Date dueDateParsed = sdf.parse(dueDate);
        
        if (transactionDate.after(dueDateParsed)) {
        	nstatus = "Overdue"; 
        }else
        {
		    if (t1 > 0 && t1<bamt ) {
		        nstatus = "Partially Paid";
		    } else {
		        nstatus = "Paid";
		    }
		    PreparedStatement p3 = Utility.getPreparedStatement("update bill set status = ? , due_amount = ? where bill_number = ?");
		    p3.setString(1, nstatus);
		    p3.setInt(3, pm.getBillNumber());
		    p3.setDouble(2, t1);
		    p3.executeUpdate();
	    }
        
	    return res;
	}
	
	public static double fetchDueAmount(int billid) throws ClassNotFoundException, SQLException
	{
		PreparedStatement p1 = Utility.getPreparedStatement("select * from bill where bill_number = ?");
		p1.setInt(1, billid);
		ResultSet r1 = p1.executeQuery();
		double due_amt = 0;
		while(r1.next())
		{
			due_amt = r1.getDouble("due_amount");
		}
		return due_amt;
	}

}
