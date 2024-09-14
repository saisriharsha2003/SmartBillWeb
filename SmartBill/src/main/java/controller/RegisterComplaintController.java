package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ComplaintModel;
import view.ComplaintsView;

@WebServlet("/RegisterComplaintController")
public class RegisterComplaintController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterComplaintController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		long consno = Long.parseLong(request.getParameter("fcno"));
		String land = request.getParameter("land");
		String ser = request.getParameter("stype");
		String cat = request.getParameter("ccat");
		long mob = Long.parseLong(request.getParameter("fphno"));
		String conp = request.getParameter("cpname");
		String prb = request.getParameter("fprob");
		String addr = request.getParameter("faddr");
		
		Random random = new Random();
		int min = 10000000;
		int max = 99999999;
		int compno = min + (int) (random.nextDouble() * (max - min + 1));
		
		ComplaintModel comp=new ComplaintModel(compno, consno, land, ser, cat, mob, conp, prb, addr);
		
		try {
			int res = ComplaintsView.registerComplaint(comp);
			if(res == 1)
			{
				HttpSession session = request.getSession();
				
				HashMap<String, String> mp1=new HashMap<>();
				mp1.put("comp_id", String.valueOf(comp.getComplaintId()));
				mp1.put("comp_per", comp.getContactPerson());
				mp1.put("comp_mobile", String.valueOf(comp.getMobile()));
				mp1.put("comp_problem", comp.getProlem());
				mp1.put("comp_address", comp.getAddress());
				
				if(session.getAttribute("complaint-details") == null)
				{
					session.setAttribute("complaint-details", mp1);
				}
				else
				{
					session.removeAttribute("complaint-details");
					session.setAttribute("complaint-details", mp1);
				}
				response.sendRedirect("source/complaint_success.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
