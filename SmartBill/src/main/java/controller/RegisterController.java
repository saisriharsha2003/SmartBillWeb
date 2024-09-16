package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.RegisterLogic;
import model.RegisterModel;

@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		long mobile = Long.parseLong(request.getParameter("mobile"));
		String gender = request.getParameter("gender");
		String user = request.getParameter("uname");
		String pwd = request.getParameter("password");
		
		Random random = new Random();
		long min = 1000000000000L;
		long max = 9999999999999L;
		long randomNumber = min + (long) (random.nextDouble() * (max - min + 1));
		
		RegisterModel reg = new RegisterModel(randomNumber, title, name, email, mobile, gender, user, pwd);
		
		try {
			boolean isexist = RegisterLogic.isAlreadyExist(reg);
			if(!isexist)
			{
				int n1 = RegisterLogic.registerConsumer(reg);
				if(n1==1)
				{
					HttpSession session = request.getSession();
					session.setAttribute("consumer_number", reg.getConsumerId()); 
					session.setAttribute("name", reg.getName());
					session.setAttribute("username", reg.getUserName());
	
					
					response.sendRedirect("success.jsp");
				}
			}
			else
			{
				request.setAttribute("er_cname", name);
                request.setAttribute("er_title", title);
                request.setAttribute("er_email", email);
                request.setAttribute("er_mob", mobile);
                request.setAttribute("er_gen", gender);
                request.setAttribute("er_user", user);
                request.setAttribute("er_pwd", pwd);

                request.setAttribute("error_msg", "Consumer already exist. Kindly login.");
                request.getRequestDispatcher("register.jsp").forward(request, response);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			
		}
	}

}
