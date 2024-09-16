package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.ComplaintsLogic;


@WebServlet("/ComplaintStatus")
public class ComplaintStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ComplaintStatusController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		long conid = Long.parseLong(session.getAttribute("consumer_lgid").toString());
		try {
			List<HashMap<String, String>> l1 = ComplaintsLogic.fetchAllComplaints(conid);
			session.setAttribute("view_all_comp", l1);

			response.sendRedirect("source/view_all_complaints.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
