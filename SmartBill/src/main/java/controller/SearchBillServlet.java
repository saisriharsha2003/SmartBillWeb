package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.BillsLogic;
import logic.ComplaintsLogic;

@WebServlet("/SearchBills")
public class SearchBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchBillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int compid = Integer.parseInt(request.getParameter("search_billid"));
		try {
			HashMap<String, String> sbill = BillsLogic.fetchBillDetailsById(compid);
			HttpSession session = request.getSession();
			session.setAttribute("search_bill_id", sbill);

			response.sendRedirect("source/bill_details_id.jsp");
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
