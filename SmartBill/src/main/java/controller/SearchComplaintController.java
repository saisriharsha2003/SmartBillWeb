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

import view.ComplaintsView;

@WebServlet("/SearchComplaint")
public class SearchComplaintController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchComplaintController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int compid = Integer.parseInt(request.getParameter("search_compid"));
		try {
			HashMap<String, String> scomp = ComplaintsView.fetchComplaintDetailsById(compid);
			HttpSession session = request.getSession();
			session.setAttribute("search_complaint_id", scomp);

			response.sendRedirect("source/complaint_details_id.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
