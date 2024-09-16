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

import logic.LoginLogic;
import logic.RegisterLogic;

@WebServlet("/EditProfile")
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String ucname = request.getParameter("edit-name");
		String email = request.getParameter("edit-email");
		Long mob = Long.parseLong(request.getParameter("edit-mobile"));
		String uuname = request.getParameter("edit-uname");
		String upwd = request.getParameter("edit-password");
		long cid = (long)session.getAttribute("consumer_lgid");
		
		try {
			int res1 = RegisterLogic.updateRegisterDetails(cid, ucname, email, mob, uuname, upwd);
			int res2 = LoginLogic.updateLoginDetails(cid, uuname, upwd);
			if(res1 == 1 && res2 == 1)
			{
				HashMap<String, String> mp=new HashMap<String, String>();
				
				mp.put("up-cname", ucname);
				mp.put("up-email", email);
				mp.put("up-mob", mob.toString());
				mp.put("up-uname", uuname);
				
				session.setAttribute("updated_user_details", mp);
				
				session.setAttribute("consumer_lgname", ucname);
								
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
