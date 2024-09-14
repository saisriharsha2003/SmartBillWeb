package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ReceiptController")
public class ReceiptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReceiptController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Random random = new Random();
		long min = 10000000000L;
		long max = 99999999999L;
		long randomNumber = min + (long) (random.nextDouble() * (max - min + 1));
		HttpSession session = request.getSession();
		session.setAttribute("receipt_number", randomNumber);

		response.sendRedirect("source/view_receipt.jsp");
	}

	
}
