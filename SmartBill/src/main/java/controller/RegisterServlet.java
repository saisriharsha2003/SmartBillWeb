package controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.RegisterLogic;
import model.RegisterModel;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Collect request parameters
        String title = request.getParameter("title");
        long consNo = Long.parseLong(request.getParameter("cnumber"));
        String meterNo = request.getParameter("mnumber");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        long mobile = Long.parseLong(request.getParameter("mobile"));
        String gender = request.getParameter("gender");
        String user = request.getParameter("uname");
        String pwd = request.getParameter("password");

        // Create RegisterModel object
        RegisterModel reg = new RegisterModel(consNo, meterNo, title, name, email, mobile, gender, user, pwd);

        try {
            // Check if consumer number is found
            boolean isCnoFound = RegisterLogic.isConsumerNumberFound(reg);
            if (isCnoFound) {
                boolean isCnoExist = RegisterLogic.isConsumerNumberAlreadyExists(reg);
                boolean isMnoMatch = RegisterLogic.isMeterNumberMatch(reg);
                boolean isMnoExist = RegisterLogic.isMeterNumberExists(reg);

                if (isCnoExist) {
                    setErrorAttributes(request, consNo, meterNo, name, title, email, mobile, gender, user, pwd);
                    request.setAttribute("error_msg", "Consumer with the mentioned Consumer Number already exists.");
                } else if (isMnoMatch) {
                    if (isMnoExist) {
                        setErrorAttributes(request, consNo, meterNo, name, title, email, mobile, gender, user, pwd);
                        request.setAttribute("error_msg", "Consumer with the mentioned Meter Number already exists.");
                    } else {
                        boolean isExist = RegisterLogic.isAlreadyExist(reg);
                        if (!isExist) {
                            int result = RegisterLogic.registerConsumer(reg);
                            if (result == 1) {
                                HttpSession session = request.getSession();
                                session.setAttribute("consumer_number", reg.getConsumerNumber()); 
                                session.setAttribute("name", reg.getName());
                                session.setAttribute("username", reg.getUserName());
                                response.sendRedirect("success.jsp");
                                return;
                            }
                        } else {
                            setErrorAttributes(request, consNo, meterNo, name, title, email, mobile, gender, user, pwd);
                            request.setAttribute("error_msg", "Consumer with the mentioned username or email already exists.");
                        }
                    }
                } else {
                    setErrorAttributes(request, consNo, meterNo, name, title, email, mobile, gender, user, pwd);
                    request.setAttribute("error_msg", "Wrong meter number for the mentioned Consumer Number.");
                }
            } else {
                setErrorAttributes(request, consNo, meterNo, name, title, email, mobile, gender, user, pwd);
                request.setAttribute("error_msg", "Consumer with the mentioned Consumer Number not found.");
            }

            request.getRequestDispatcher("register.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("error_msg", "An error occurred while processing your request.");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }

    private void setErrorAttributes(HttpServletRequest request, long consNo, String meterNo, String name, String title, String email, long mobile, String gender, String user, String pwd) {
        request.setAttribute("er_cnumber", consNo);
        request.setAttribute("er_mnumber", meterNo);
        request.setAttribute("er_cname", name);
        request.setAttribute("er_title", title);
        request.setAttribute("er_email", email);
        request.setAttribute("er_mob", mobile);
        request.setAttribute("er_gen", gender);
        request.setAttribute("er_user", user);
        request.setAttribute("er_pwd", pwd);
    }
}
