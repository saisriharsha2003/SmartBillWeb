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

@WebServlet("/AdminViewBills")
public class AdminViewBillsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AdminViewBillsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			int res = AdminLogic.updatePenalty();
			List<HashMap<String, String>> h1 = AdminLogic.fetchAllBillsAdmin();
			HttpSession session = request.getSession();
			session.setAttribute("admin_bills", h1);
			response.sendRedirect("source/admin_view_bills.jsp");
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
