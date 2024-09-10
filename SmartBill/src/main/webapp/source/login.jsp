<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <link rel="stylesheet" href="../style.css">
    <link rel="icon" href="../assets/icon.png" type="image/icon type">
    <title>Login</title>
  </head>
  <body>
    <div>
      <div class="hero">
        <nav>
            <a href="../index.jsp"><img class="logo"
                  src="../assets/logo.png"></a>
            <ul>
              <li><a href="../index.jsp">Home</a></li>
              <li><a href="#">About</a></li>
              <li><a href="#">Contact</a></li>
              <button class="ind_button"><a class="b1" href="register.jsp">Register</a></button>
              <button class="ind_button"><a class="b1" href="login.jsp">Login</a></button>
            </ul>
        </nav>
      </div>
      <div class="signup">
        <div class="container">
          <div class="title">Login to SmartBill</div>
          <form id="my_login_form" action="<%=request.getContextPath()%>/Login" method = "post">
            <div class="user-details">
              <div class="input-box">
                <span class="details">User Name</span>
                <input type="text" id='lname' placeholder="Enter your User Name"
                  name="lname" required
                  oninvalid="this.setCustomValidity('Please Enter Username')"
                  onchange="this.setCustomValidity('')">
              </div>
              <div class="input-box">
                <span class="details">Password</span>
                <input type="password" id="lpwd" name = "lpwd"
                  placeholder="Enter your Password" required
                  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                  title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
                  onkeyup='login_check();'>
              </div>
              <div class="input-box">
                <span class="details">Confirm Password</span>
                <input type="password" id="lcpwd"
                  placeholder="Confirm your Password" required
                  oninvalid="this.setCustomValidity('Please Enter Password Again')"
                  onchange="this.setCustomValidity('')"
                  onkeyup='login_check();'>
                <span class="message" id='login_message'></span>
              </div>
              <div class="input-box">
              	<span class="details">Login As</span>
	
                <select class="drtitle" name = "userType">
                  <option value="Default" selected>Select User Type</option>
                  <option value="Admin">Admin</option>
                  <option value="Consumer">Consumer</option>
     
                </select>
              </div>
            </div>
            <div class="sbutton">
              <input type="submit" id="aButton" value="Login" style = "cursor: pointer">
              <span class="lmessage1" id='llogin_message'></span>
            </div>
            <div class="asignup">Don't have an account? <a href="register.jsp"
                class='bsignup'> Register </a> here</div>
          </form>
          <script src="../scripts/script.js"></script>
         
        </div>
      </div>
    </div>
  </body>
</html>