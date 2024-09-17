package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.AdminLogic;
import logic.BillsLogic;


@WebServlet("/PayBills")
public class PayBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public PayBillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		long conid = Long.parseLong(String.valueOf(session.getAttribute("consumer_lgid")));
		try {
			int res = AdminLogic.updatePenalty();
			List<HashMap<String, String>> l1 = BillsLogic.fetchAllBillsPay(conid);
			session.setAttribute("view_all_bills", l1);

			response.sendRedirect("source/pay_bills.jsp");
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
