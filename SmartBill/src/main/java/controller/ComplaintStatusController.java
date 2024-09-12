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

import view.ComplaintsView;


@WebServlet("/ComplaintStatus")
public class ComplaintStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ComplaintStatusController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		long conid = Long.parseLong(request.getAttribute("consumer_lgid").toString());
		try {
			int compid = ComplaintsView.fetchComplaintId(conid);
			List<HashMap<String, String>> l1 = ComplaintsView.fetchAllComplaints(compid);
			if(session.getAttribute("view_all_comp") == null)
			{
				session.setAttribute("view_all_comp", l1);
			}
			else
			{
				session.removeAttribute("view_all_comp");
				session.setAttribute("view_all_comp", l1.toString());
			}
			response.sendRedirect("view_all_complaints.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
