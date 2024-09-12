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


@WebServlet("/AdminViewConsumers")
public class AdminViewConsumersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AdminViewConsumersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<HashMap<String, String>> h1= AdminView.fetchAllConsumers();
			HttpSession session = request.getSession();
			if(session.getAttribute("admin_consumers") == null)
			{
				session.setAttribute("admin_consumers", h1);
			}
			else
			{
				session.removeAttribute("admin_consumers");
				session.setAttribute("admin_consumers", h1);
			}
			response.sendRedirect("source/admin_view_consumers.jsp");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
