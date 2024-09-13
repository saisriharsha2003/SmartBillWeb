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

import view.AdminView;
import view.BillsView;
import view.PaymentsView;

@WebServlet("/PaymentScreenController")
public class PaymentScreenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaymentScreenController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int billid = Integer.parseInt(request.getParameter("up_bill"));
		HashMap<String, String> mp;
		try {
			double due_amt = PaymentsView.fetchDueAmount(billid);

			mp = BillsView.fetchPaymentBillDetails(billid);
			if(session.getAttribute("payment_billdet") == null)
			{
				session.setAttribute("payment_billdet", mp);
				
			}
			else
			{
				session.removeAttribute("payment_billdet");
				session.setAttribute("payment_billdet", mp);
			}
			
			if(session.getAttribute("payment_due_amount") == null)
			{
				session.setAttribute("payment_due_amount", due_amt);
				
			}
			else
			{
				session.removeAttribute("payment_due_amount");
				session.setAttribute("payment_due_amount", due_amt);
			}
			
			response.sendRedirect("source/bill_details.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}
