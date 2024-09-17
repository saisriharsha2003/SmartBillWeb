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

import logic.AdminLogic;


@WebServlet("/AdminViewComplaints")
public class AdminViewComplaintsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminViewComplaintsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<HashMap<String, String>> h1 = AdminLogic.fetchAllComplaints();
			HttpSession session = request.getSession();
			session.setAttribute("admin_complaints", h1);
			response.sendRedirect("source/admin_view_complaints.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
