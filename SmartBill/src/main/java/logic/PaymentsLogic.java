package logic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.derby.client.am.Statement;

import model.PaymentModel;
import utility.Utility;

public class PaymentsLogic {
	public static int makePayment(PaymentModel pm, long conid) throws ClassNotFoundException, SQLException, ParseException {
	    PreparedStatement p1 = Utility.getPreparedStatement("insert into payment values(?,?,?,?,?,?)");
	    p1.setInt(1, pm.getTransactionNumber());
	    p1.setInt(2, pm.getBillNumber());
	    p1.setDouble(3, pm.getPaidAmount());
	    p1.setString(4, pm.getTransactionMode());
	    p1.setString(5, pm.getTransactionDate());  
	    p1.setLong(6, pm.getConsumerId());
	    int res = p1.executeUpdate();

	    PreparedStatement p2 = Utility.getPreparedStatement("select * from bill where bill_number = ?");
	    p2.setInt(1, pm.getBillNumber());
	    ResultSet rs = p2.executeQuery();
	    
	    double bamt = 0;
	    double edamt = 0;
	    String dueDate = "";
	    double pen = 0;
	    String estatus = "";
	    while (rs.next()) {
	        bamt = rs.getDouble("bill_amount");
	        edamt = rs.getDouble("due_amount");
	        dueDate = rs.getString("due_date"); 
	        pen = rs.getDouble("penalty");
	        estatus = rs.getString("status");
	    }

	    String nstatus = "";
	    double t1 = edamt - pm.getPaidAmount() ;
	    if(t1==0 && pen == 0)
	    {
	    	t1=0;
	    }
	    else if(t1<0 && pen>0)
	    {
	    	pen = pen + t1;
	    	t1=0;	
	    }
	    else if(t1<0 && pen == 0)
	    {
	    	t1=0;
	    }
	    else
	    {
	    	t1+=0;
	    }
        
	    if(t1>0)
	    {
	    	if(pen>0)
	    	{
	    		nstatus = "Overdue";
	    	}
	    	else
	    	{
	    		nstatus = "Partially Paid";
	    	}
	    }
	    else if(t1==0)
	    {
	    	if(pen>0)
	    	{
	    		nstatus = "Overdue";
	    	}
	    	else
	    	{
	    		nstatus = "Paid";
	    	}
	    }
	    PreparedStatement p3 = Utility.getPreparedStatement("update bill set status = ? , due_amount = ?, penalty = ? where bill_number = ?");
	    p3.setString(1, nstatus);
	    p3.setInt(4, pm.getBillNumber());
	    p3.setDouble(2, t1);
	    p3.setDouble(3, pen);
	    p3.executeUpdate();
	    
        
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
	
	public static List<HashMap<String, String>> fetchAllPayments(long conid) throws ClassNotFoundException, SQLException
	{
		List<HashMap<String, String>> ln=new ArrayList<HashMap<String, String>>();
		PreparedStatement p1= Utility.getPreparedStatement("select * from payment where consumer_id = ?");
		p1.setLong(1, conid);
		ResultSet rs = p1.executeQuery();
		while(rs.next()) {
			HashMap<String, String> mp1=new HashMap<String, String>();
			mp1.put("tran_no", String.valueOf(rs.getInt("transcation_number")));
			mp1.put("bill_no", String.valueOf(rs.getString("bill_number")));
			mp1.put("paid_amt", String.valueOf(rs.getDouble("paid_amount")));
			mp1.put("tran_mode", rs.getString("transaction_mode"));
			mp1.put("tran_date", rs.getString("transaction_date"));
			ln.add(mp1);
		}
		return ln;
	}
	
	public static boolean isTransactionFound(int tran_id) throws ClassNotFoundException, SQLException
	{
		Statement st = (Statement) Utility.getStatement();
		ResultSet r1 = st.executeQuery("select * from payment");
		while(r1.next())
		{
			System.out.println(r1.getInt("transcation_number") +"  "+tran_id);
			int tran_no = r1.getInt("transcation_number");
			if(tran_id == tran_no);
			{
				return true;
			}
		}
		return false;
	}
	
	public static HashMap<String, String> searchTransaction(int tran_id) throws ClassNotFoundException, SQLException
	{
		HashMap<String, String> mp1=new HashMap<String, String>();
		PreparedStatement p1= Utility.getPreparedStatement("select * from payment where transcation_number = ?");
		p1.setLong(1, tran_id);
		ResultSet rs = p1.executeQuery();
		while(rs.next()) {
			mp1.put("tran_no", String.valueOf(rs.getInt("transcation_number")));
			mp1.put("bill_no", String.valueOf(rs.getString("bill_number")));
			mp1.put("paid_amt", String.valueOf(rs.getDouble("paid_amount")));
			mp1.put("tran_mode", rs.getString("transaction_mode"));
			mp1.put("tran_date", rs.getString("transaction_date"));
		}
		return mp1;
	}

}
