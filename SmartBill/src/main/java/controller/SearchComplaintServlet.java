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

import logic.ComplaintsLogic;

@WebServlet("/SearchComplaint")
public class SearchComplaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchComplaintServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int compid = Integer.parseInt(request.getParameter("search_compid"));
		
		try {
			boolean iscomp = ComplaintsLogic.isComplaintExist(compid);
			if(iscomp){
				HashMap<String, String> scomp = ComplaintsLogic.fetchComplaintDetailsById(compid);
				HttpSession session = request.getSession();
				session.setAttribute("search_complaint_id", scomp);
	
				response.sendRedirect("source/complaint_details_id.jsp");
			}else
			{
				request.setAttribute("er_comp_id", compid);

                request.setAttribute("error_msg", "Complaint Details for above mentioned complaint id not found.");
                request.getRequestDispatcher("source/search_complaint.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
