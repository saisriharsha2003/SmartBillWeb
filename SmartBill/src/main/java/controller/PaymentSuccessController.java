package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PaymentModel;
import view.PaymentsView;

@WebServlet("/PaymentSuccess")
public class PaymentSuccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PaymentSuccessController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		long conid = Long.parseLong(session.getAttribute("consumer_lgid").toString());

		HashMap<String, String> mp = (HashMap<String, String>) session.getAttribute("payment_billdet");
		System.out.println(mp);
		int bill_id = Integer.parseInt(mp.get("bill_id"));
		String pay_mode = (String) session.getAttribute("billdet_paymode");
		double paid_amt = Double.parseDouble((String) session.getAttribute("billdet_pamount"));

		Date today = new Date();
		SimpleDateFormat displayFormat = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDisplayDate = displayFormat.format(today);

		Random random = new Random();
		int min = 100000000;
		int max = 999999999;
		int randomNumber = min + random.nextInt(max - min + 1);

		PaymentModel pm = new PaymentModel(randomNumber, bill_id, paid_amt, pay_mode, formattedDisplayDate, conid);

		try {
			int res = PaymentsView.makePayment(pm, conid);
			
			if (res == 1) {
				HashMap<String, String> paymentDetails = new HashMap<>();
				paymentDetails.put("payment_id", String.valueOf(randomNumber));
				paymentDetails.put("payment_billid", String.valueOf(bill_id));
				paymentDetails.put("payment_paidamt", String.valueOf(paid_amt));
				paymentDetails.put("payment_mode", pay_mode);
				paymentDetails.put("payment_date", formattedDisplayDate);
				if( session.getAttribute("payment_details") ==null)
				{
					session.setAttribute("payment_details", paymentDetails);
				}
				else
				{
					session.removeAttribute("payment_details");
					session.setAttribute("payment_details", paymentDetails);
				}

				response.sendRedirect("source/payment_success.jsp");
			}
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "An error occurred while processing the payment.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
			dispatcher.forward(request, response);
		}
	}
}
