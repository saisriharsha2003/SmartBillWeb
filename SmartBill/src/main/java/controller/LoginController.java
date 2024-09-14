package controller;

import model.LoginModel;
import model.RegisterModel;
import view.LoginView;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
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
		
		System.out.println(uname+"  uname"+"  "+ut);

		if(ut.equalsIgnoreCase("Admin"))
		{
			try {
				LoginModel lg=new LoginModel(uname, pwd);

				boolean status = LoginView.authenticateAdmin(lg);
				if(status == true)
				{
					HttpSession session = request.getSession();
					session.setAttribute("consumer_lgname", "Admin");

					response.sendRedirect("source/admin_home.jsp");
				}
				else
				{
					request.setAttribute("en_username", uname);
	                request.setAttribute("user_type", ut);
	                request.setAttribute("en_password", pwd);
	                request.setAttribute("error_msg", "Invalid Admin credentials.");
	                request.getRequestDispatcher("source/login.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		else
		{
			try {
				
				boolean isexist = LoginView.isUserExist(uname);
				if(isexist)
				{
					LoginModel lg1=new LoginModel(uname, pwd);
					boolean act_status = LoginView.fetchAccountStatus(uname);
					
					if(act_status)
					{
						boolean status1 = LoginView.authenticateConsumer(lg1);
						if(status1 == true)
						{
							String cname = LoginView.fetchConsumerName(uname);
							long cid = LoginView.fetchConsumerId(uname);
							HttpSession session = request.getSession();
							session.setAttribute("consumer_lgid", cid);
							session.setAttribute("consumer_lgname", cname);

							HashMap<String, String> mp = LoginView.fetchUserDetails(uname);
							session.setAttribute("user-details", mp);
							
							response.sendRedirect("source/home.jsp");

						}
						else
						{
							request.setAttribute("en_username", uname);
			                request.setAttribute("user_type", ut);
			                request.setAttribute("en_password", pwd);
			                request.setAttribute("error_msg", "Invalid login credentials. Kindly check once.");
			                request.getRequestDispatcher("/source/login.jsp").forward(request, response);
			            
						}
					}
					else
					{
						HttpSession session = request.getSession();
						session.setAttribute("reactivate_uname", uname);
						response.sendRedirect("reactivate.jsp");
					}
				}
				else
				{
					request.setAttribute("en_username", uname);
	                request.setAttribute("user_type", ut);
	                request.setAttribute("en_password", pwd);
	                request.setAttribute("error_msg", "Consumer doesn't exist. Kindly check the credentials once.");
	                request.getRequestDispatcher("/source/login.jsp").forward(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
