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

import logic.PaymentsLogic;

@WebServlet("/SearchPayment")
public class SearchPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchPaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tran_id = Integer.parseInt(request.getParameter("search_tranid"));
		HttpSession session= request.getSession();
		try {
			boolean isexist = PaymentsLogic.isTransactionFound(tran_id);
			System.out.println(isexist);
			if(isexist)
			{
				HashMap<String, String> m1= PaymentsLogic.searchTransaction(tran_id);
			
				session.setAttribute("payment_details_id", m1);

				response.sendRedirect("source/payment_details_id.jsp");
			}
			else
			{
				request.setAttribute("er_tranid", tran_id);

                request.setAttribute("error_msg", "Transaction Details for above mentioned transaction number not found.");
                request.getRequestDispatcher("source/search_payment.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
