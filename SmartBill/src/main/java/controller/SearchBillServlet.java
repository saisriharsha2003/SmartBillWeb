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
		
		int bill_id = Integer.parseInt(request.getParameter("search_billid"));
		try {
			boolean isbill = BillsLogic.isBillExist(bill_id);
			if(isbill){

			HashMap<String, String> sbill = BillsLogic.fetchBillDetailsById(bill_id);
			HttpSession session = request.getSession();
			session.setAttribute("search_bill_id", sbill);

			response.sendRedirect("source/bill_details_id.jsp");
			}
			else
			{
				request.setAttribute("er_bill_id", bill_id);
                request.setAttribute("error_msg", "Bill Details for above mentioned bill number not found.");
                request.getRequestDispatcher("source/search_bill.jsp").forward(request, response);


			}
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
