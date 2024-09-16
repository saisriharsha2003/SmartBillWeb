package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.AdminLogic;
import logic.BillsLogic;
import logic.PaymentsLogic;

@WebServlet("/BillDetails")
public class BillDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BillDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int billid = Integer.parseInt(request.getParameter("up_bill"));
		HashMap<String, String> mp;
		try {
			double due_amt = PaymentsLogic.fetchDueAmount(billid);

			mp = BillsLogic.fetchPaymentBillDetails(billid);
			session.setAttribute("payment_billdet", mp);
			session.setAttribute("payment_due_amount", due_amt);
			
			response.sendRedirect("source/bill_details.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}
