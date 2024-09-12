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

import view.LoginView;
import view.RegisterView;

@WebServlet("/EditProfile")
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ucname = request.getParameter("edit-name");
		String email = request.getParameter("edit-email");
		Long mob = Long.parseLong(request.getParameter("edit-mobile"));
		String uuname = request.getParameter("edit-uname");
		String upwd = request.getParameter("edit-password");
		
		try {
			int res1 = RegisterView.updateRegisterDetails(ucname, email, mob, uuname, upwd);
			int res2 = LoginView.updateLoginDetails(uuname, upwd);
			if(res1 == 1 && res2 == 1)
			{
				HttpSession session = request.getSession();
				session.setAttribute("up-cname", ucname);
				session.setAttribute("up-email", email);
				session.setAttribute("up-mob", mob);
				session.setAttribute("up-uname", uuname);
				
				session.removeAttribute("consumer_lgname");
				session.setAttribute("consumer_lgname", ucname);
				
				session.removeAttribute("user-detials");
				
				HashMap<String, String> mp1 = new HashMap<>();
				mp1.put("name", ucname);
				mp1.put("email", email);
				mp1.put("mobile", mob.toString());
				mp1.put("username", uuname);
				mp1.put("password", upwd);
				session.setAttribute("user-details", mp1);
				
				
				response.sendRedirect("source/update_success.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
