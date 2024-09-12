package controller;

import model.LoginModel;
import model.RegisterModel;
import view.LoginView;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("lname");
		String pwd = request.getParameter("lpwd");
		String ut = request.getParameter("userType");

		if(ut.equalsIgnoreCase("Admin"))
		{
			try {
				LoginModel lg=new LoginModel(uname, pwd);

				boolean status = LoginView.authenticateAdmin(lg);
				if(status == true)
				{
					HttpSession session = request.getSession();
					if(session.getAttribute("consumer_lgname") == null)
					{
						session.setAttribute("consumer_lgname", "Admin");
					}
					else
					{
						session.removeAttribute("consumer_lgname");
						session.setAttribute("consumer_lgname", "Admin");
					}
					response.sendRedirect("source/admin_home.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		else
		{
			try {
				LoginModel lg1=new LoginModel(uname, pwd);

				boolean status1 = LoginView.authenticateConsumer(lg1);
				System.out.println("status"+status1);
				if(status1 == true)
				{
					String cname = LoginView.fetchConsumerName(uname);
					long cid = LoginView.fetchConsumerId(uname);
					HttpSession session = request.getSession();
					if(session.getAttribute("consumer_lgid") == null)
					{
						session.setAttribute("consumer_lgid", cid);
					}
					else
					{
						session.removeAttribute("consumer_lgid");
						session.setAttribute("consumer_lgid", cid);
					}
					if(session.getAttribute("consumer_lgname") == null)
					{
						session.setAttribute("consumer_lgname", cname);
					}
					else
					{
						session.removeAttribute("consumer_lgname");
						session.setAttribute("consumer_lgname", cname);
					}
					HashMap<String, String> mp = LoginView.fetchUserDetails(uname);

					if(session.getAttribute("user-details") == null)
					{
						session.setAttribute("user-details", mp);
					}
					else
					{
						session.removeAttribute("user-details");
						session.setAttribute("user-details", mp);
					}
						
					response.sendRedirect("source/home.jsp");

				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
