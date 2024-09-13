package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import view.BillsView;


@WebServlet("/PayBills")
public class PayBillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public PayBillController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		long conid = Long.parseLong(String.valueOf(session.getAttribute("consumer_lgid")));
		try {
			List<HashMap<String, String>> l1 = BillsView.fetchAllBills(conid);
			if(session.getAttribute("view_all_bills") == null)
			{
				session.setAttribute("view_all_bills", l1);
			}
			else
			{
				session.removeAttribute("view_all_bills");
				session.setAttribute("view_all_bills", l1);
			}
			response.sendRedirect("source/pay_bills.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
