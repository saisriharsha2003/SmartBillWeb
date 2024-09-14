package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/PaymentScreen")
public class PaymentScreenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaymentScreenController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pay_amount = (String)request.getParameter("billdet_pamt");
		String pay_mode = (String)request.getParameter("pay_mode");
		HttpSession session = request.getSession();
		System.out.println(pay_amount+"  "+ pay_mode);
		if(session.getAttribute("billdet_pamount") == null)
		{
			session.setAttribute("billdet_pamount", pay_amount);
		}
		else
		{
			session.removeAttribute("billdet_pamount");
			session.setAttribute("billdet_pamount", pay_amount);
		}
		if(session.getAttribute("billdet_paymode") == null)
		{
			session.setAttribute("billdet_paymode", pay_mode);
		}
		else
		{
			session.removeAttribute("billdet_paymode");
			session.setAttribute("billdet_paymode", pay_mode);
		}
		response.sendRedirect("source/payment_screen.jsp");
	}
	

}
