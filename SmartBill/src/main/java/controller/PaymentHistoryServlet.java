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

import logic.PaymentsLogic;

@WebServlet("/PaymentHistory")
public class PaymentHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaymentHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		long conid = Long.parseLong(session.getAttribute("consumer_lgid").toString());
		try {
			List<HashMap<String, String>> mp1 = PaymentsLogic.fetchAllPayments(conid);
			session.setAttribute("payment_details_con", mp1);

			response.sendRedirect("source/payment_history.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
