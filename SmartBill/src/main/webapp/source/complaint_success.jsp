<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="../style.css">
    <link rel="icon" href="../assets/icon.png" type="image/icon type">
    <title>Complaint Registered</title>
  </head>
  <body>
    <div>
      <div class="hero">
        <nav>
            <a href="home.jsp"><img class="logo"
                  src="../assets/logo.png"></a>
            <ul>
              <li><a href="home.jsp">Home</a></li>
              <li><a href="paybill.html">Pay Bill</a></li>
              <li><a href="register_complaint.jsp">Register Complaint</a></li>
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
		        	<a href="#" class="sub-menu-link">
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
          <div class='title' style="font-size: 25px; color: #008000">Complaint Registered Successfully!</div>
          <div class='details-cont'>
            <table>
              <tbody>
                <tr>
                  <td><span class='cust'>Complaint Number</span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='cocno'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'>Contact Person</span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='cocnp'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'> Mobile Number</span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='com'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'>Problem</span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='cop'></span></td>
                </tr>
                
                <tr>
                  <td><span class='cust'> Address</span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='addr'></span></td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="sbutton">
            <input type="submit" id="bButton" value="Back to Home" style="cursor: pointer;"
              onclick="window.location='home.jsp';">
          </div>
        </div>
      </div>
	<script>
		let subm = document.getElementById("subMenu");
		function toggleMenu() {
			subm.classList.toggle("open-menu");
		}
		var name = '<%= (session.getAttribute("consumer_lgname") != null) ? session.getAttribute("consumer_lgname") : "" %>';
  		var c6 = document.getElementById("cu_name");
  		if(c6) c6.textContent = name;
  		
		var cn1 = document.getElementById("cocno");
		var cn2 = document.getElementById("cocnp");
		var cn3 = document.getElementById("com");
		var cn4 = document.getElementById("cop");
		var cn5 = document.getElementById("addr");
		
		var compno = '<%= (session.getAttribute("comp_id") != null) ? session.getAttribute("comp_id") : "" %>';
		var contp = '<%= (session.getAttribute("comp_per") != null) ? session.getAttribute("comp_per") : "" %>';
		var mob = '<%= (session.getAttribute("comp_mobile") != null) ? session.getAttribute("comp_mobile").toString() : "" %>';
		var prob = '<%= (session.getAttribute("comp_problem") != null) ? session.getAttribute("comp_problem") : "" %>';
		var addr = '<%= (session.getAttribute("comp_address") != null) ? session.getAttribute("comp_address") : "" %>';
		console.log(compno);
		if (cn1) cn1.textContent = compno;
        if (cn2) cn2.textContent = contp;
        if (cn3) cn3.textContent = mob;
        if (cn4) cn4.textContent = prob;
        if (cn5) cn5.textContent = addr;
	
	</script>
    </div>
  </body>
</html>