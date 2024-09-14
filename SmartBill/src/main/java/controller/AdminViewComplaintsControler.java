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


@WebServlet("/AdminViewComplaints")
public class AdminViewComplaintsControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AdminViewComplaintsControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<HashMap<String, String>> h1 = AdminView.fetchAllComplaints();
			HttpSession session = request.getSession();
			session.setAttribute("admin_complaints", h1);
			response.sendRedirect("source/admin_view_complaints.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
