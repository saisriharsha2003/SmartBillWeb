package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import view.LoginView;

@WebServlet("/DeleteAccount")
public class DeleteAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		long conid = (long)session.getAttribute("consumer_lgid");
		try {
			int res = LoginView.softDeleteAccount(conid);
			if(res == 1)
			{
				response.sendRedirect("source/delete_success.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
