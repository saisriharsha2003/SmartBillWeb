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

import view.AdminView;

@WebServlet("/UpdateComplaint")
public class AdminUpdateComplaintController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminUpdateComplaintController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int cmpid = Integer.parseInt(request.getParameter("up_comp"));
		System.out.println(cmpid);
		try {
			int res = AdminView.updateComplaint(cmpid);
			if(res == 1)
			{
				HashMap<String, String> lh1 = AdminView.fetchUpdatedComplaint(cmpid);
				session.setAttribute("upd_comp_det", lh1);
			}
			response.sendRedirect("source/admin_complaint_update.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
