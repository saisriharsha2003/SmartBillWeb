<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" href="../assets/icon.png" type="image/icon type">
    <title>Updated Profile</title>
    
  </head>
  <body>
    <div>
      <div class="hero">
        <nav>
            <a href="../home.jsp"><img class="logo"
                  src="../assets/logo.png"></a>
            <ul>
              <li><a href="home.jsp">Home</a></li>
              <li><a href="paybill.html">Pay Bill</a></li>
              <li><a href="register_complaint.jsp">Register Complaint</a></li>
              <li><a href="search_complaint.jsp">Search Complaint</a></li>             
              <li><a href="complaint_status.html">Complaint Status</a></li>    
            </ul>
            <img src="../assets/user.png" class="user-pic" onclick="toggleMenu()">
            <div class="sub-menu-wrap" id="subMenu">
	        	<div class="sub-menu">
		        	<div class="user-info">
		        		<img src="../assets/user.png" style="width: 80px; height: 80px">
		        		<h2 id="cu_name" style="color:#CCBA78;"></h2>
		        	</div>
		        	<hr>
		        	<a href="edit_profile.jsp" class="sub-menu-link">
		        		<img src="../assets/edit.png" style="width: 50px; height: 50px">
		        		<p>Edit Profile</p>
		        		<span class="ext">></span>
		        	</a>
		        	<a href="login.jsp" class="sub-menu-link">
		        		<img src="../assets/logout.png" style="width: 50px; height: 50px">
		        		<p>Logout</p>
		        		<span class="ext">></span>
		        	</a>
	        	</div>
        	</div>  
        </nav>
      </div>
      <div class="signup">
        <div class="container">
          <div class='title' style="font-size: 25px; color: #008000">Thank You for Registering
            to SmartBill</div>
          <div class='details-cont'>
            <table>
              <tbody>
                <tr>
                  <td><span class='cust'>Your updated Name</span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='up_name'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'> Your updated Email</span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='up_email'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'>Your updated Mobile</span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='up_mobile'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'>Your updated Username</span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='up_uname'></span></td>
                </tr>
                
                
              </tbody>
            </table>
          </div>
          <div class="sbutton">
            <input type="submit" id="bButton" value="Back to Home" style="cursor:pointer"
              onclick="window.location='home.jsp';">
          </div>
        </div>
      </div>
    </div>
    <script type="text/javascript">
        var cn1 = document.getElementById("up_name");
        var cn2 = document.getElementById("up_email");
        var cn3 = document.getElementById("up_mobile");
        var cn4 = document.getElementById("up_uname");

        
        var p1 = '<%= (session.getAttribute("up-cname") != null) ? session.getAttribute("up-cname"): "" %>';
        var p2 = '<%= (session.getAttribute("up-email") != null) ? session.getAttribute("up-email") : "" %>';
        var p3 = '<%= (session.getAttribute("up-mob") != null) ? session.getAttribute("up-mob") : "" %>';
        var p4 = '<%= (session.getAttribute("up-uname") != null) ? session.getAttribute("up-uname") : "" %>';

        
        if (cn1) cn1.textContent = p1;
        if (cn2) cn2.textContent = p2;
        if (cn3) cn3.textContent = p3;
        if (cn4) cn4.textContent = p4;

    </script>
  </body>
</html>