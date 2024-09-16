<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
	    <link rel="icon" href="<%=request.getContextPath()%>/assets/icon.png" type="image/icon type">
	    <title>Register</title>
  	</head>
	  <body>
	    <div>
	      <div class="hero" >
	        <nav>
	            <a href="<%=request.getContextPath()%>/index.jsp"><img class="logo"
	                  src="<%=request.getContextPath()%>/assets/logo.png"></a>
	            <ul>
	              <li><a href="<%=request.getContextPath()%>/index.jsp">Home</a></li>
	              <li><a href="about.jsp">About</a></li>
	              <li><a href="contact.jsp">Contact</a></li>
	              <button class="ind_button"><a class="b1" href="register.jsp">Register</a></button>
	              <button class="ind_button"><a class="b1" href="<%=request.getContextPath()%>/login.jsp">Login</a></button>
	            </ul>
	        </nav>
	      </div>
	      <div class="signup">
	        <div class="container">
	          <div class="title">Register to SmartBill</div>
	          <form name='myform' action="<%=request.getContextPath()%>/Register" method = "post">
	            <div class="user-details">  
	              <div class="input-box">
	                <span class="details">Title</span>
	                <select name = "title" class="drtitle" 
	                value="<%= request.getAttribute("er_title") != null ? request.getAttribute("er_title") : "" %>">
	                  <option value="Default" selected>Select Title</option>
	                  <option value="Mr">Mr</option>
	                  <option value="Ms">Ms</option>
	                  <option value="Mrs">Mrs</option>
	                  <option value="Dr">Dr</option>
	                </select>
	              </div>
	              <div class="input-box">
	                <span class="details">Full Name</span>
	                <input type="text" name = "name" id='name' placeholder="Enter your Ful Name"
	                  name="name" required
	                  value="<%= request.getAttribute("er_cname") != null ? request.getAttribute("er_cname") : "" %>"
	                  oninvalid="this.setCustomValidity('Please Enter Full Name')"
	                  onchange="this.setCustomValidity('')">
	              </div>
	              <div class="input-box">
	                <span class="details">Email</span>
	                <input type="email" name = "email" id='email' placeholder="Enter your Email Id"
	                  required
	                  value="<%= request.getAttribute("er_email") != null ? request.getAttribute("er_email") : "" %>"
	                  oninvalid="this.setCustomValidity('Please Enter Valid Email')"
	                  onchange="this.setCustomValidity('')">
	              </div>
	              <div class="input-box">
	                <span class="details">Mobile Number</span>
	                <input type="text" id='phno' name = "mobile"
	                  placeholder="Enter your Mobile Number" required
	                  value="<%= request.getAttribute("er_mob") != null ? request.getAttribute("er_mob") : "" %>"
	                  oninvalid="this.setCustomValidity('Please Enter Mobile Number')"
	                  onchange="this.setCustomValidity('')">
	              </div>
	              <div class="input-box">
	                <span class="details">Gender</span>
	
	                <select name="gender" class="drtitle"  
	                value="<%= request.getAttribute("er_gender") != null ? request.getAttribute("er_gender") : "" %>">
	                  <option value="Default" selected>Select Gender</option>
	                  <option value="Male">Male</option>
	                  <option value="Female">Female</option>
	             
	                </select>
	              </div>
	              <div class="input-box">
	                <span class="details">Username</span>
	                <input name = "uname" type="text" id='uname' placeholder="Enter your Username"
	                  required value="<%= request.getAttribute("er_user") != null ? request.getAttribute("er_user") : "" %>"
	                  oninvalid="this.setCustomValidity('Please Enter Username')"
	                  onchange="this.setCustomValidity('')">
	              </div>
	              <div class="input-box">
	                <span class="details">Password</span>
	                <input type="password" id="password" name = "password"
	                  placeholder="Enter your Password" required
	                  value="<%= request.getAttribute("er_pwd") != null ? request.getAttribute("er_pwd") : "" %>"
	                  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
	                  title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
	                  onkeyup='check();'>
	              </div>
	              <div class="input-box">
	                <span class="details">Confirm Password</span>
	                <input type="password" id="cpassword"
	                  placeholder="Confirm your Password" required
	                  value="<%= request.getAttribute("er_pwd") != null ? request.getAttribute("er_pwd") : "" %>" 
	                  oninvalid="this.setCustomValidity('Please Enter Password Again')"
	                  onchange="this.setCustomValidity('')" onkeyup='check();'>
	                <span class="message" id='message'></span>
	              </div>
	               
	            </div>
	            <div class="button">
	              <button type="submit" id="aButton" style="cursor: pointer">Register</button>
	              <span class="lmessage1" id='llogin_message'><%= request.getAttribute("error_msg") != null ? request.getAttribute("error_msg") : "" %></span>
	              
	            </div>
	            <div class="asignup">Already have an account? <a href="<%=request.getContextPath()%>/login.jsp"
	                class='bsignup'> Login </a> here</div>
	          </form>
	          <script src="<%=request.getContextPath()%>/scripts/script.js"></script>
	        </div>
	      </div>
	    </div>
	  </body>
</html>