package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.LoginLogic;

@WebServlet("/ReactivateAccount")
public class ReactivateAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReactivateAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String uname = request.getParameter("lname");
		String pwd = request.getParameter("lpwd");
		String ut = request.getParameter("uerType");
		try {
			boolean res1 = LoginLogic.reauthenticateConsumer(uname, pwd);
			if(res1 == true)
			{
				int res = LoginLogic.reactivateAccount(uname);
				if(res==1)
				{
					response.sendRedirect("reactivate_success.jsp");
				}
			}
			else
			{
				request.setAttribute("en_username", uname);
                request.setAttribute("user_type", ut);
                request.setAttribute("en_password", pwd);
                request.setAttribute("error_msg", "Invalid login credentials. Kindly Check Once.");
                request.getRequestDispatcher("reactivate_login.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
