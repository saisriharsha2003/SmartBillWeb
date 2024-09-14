package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import model.BillModel;
import view.AdminView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/AdminAddBill")
public class AdminAddBillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminAddBillController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long cno = Long.parseLong(request.getParameter("adbillcn"));
		double amt = Double.parseDouble(request.getParameter("adamt"));
		String date = request.getParameter("addd");
		String status = "Unpaid";
		double pamt = amt;
		double penalty = 0;
		
		Random random = new Random();
		int min = 1000000;
		int max = 9999999;
		int billno = min + (int) (random.nextDouble() * (max - min + 1));
		
		BillModel bill = new model.BillModel(billno, amt, pamt, date, penalty, status, cno );
		
		try {
			int res = AdminView.adminAddBill(bill);
			if(res == 1)
			{
				HttpSession session = request.getSession();
				session.setAttribute("addbill_bn", bill.getBillNuber()); 
				session.setAttribute("addbill_cn", bill.getConsumerId());
				session.setAttribute("adbill_amt", bill.getBillAmount());
				session.setAttribute("adbill_date", bill.getDueDate());

				
				response.sendRedirect("source/admin_addbill_success.jsp");

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
