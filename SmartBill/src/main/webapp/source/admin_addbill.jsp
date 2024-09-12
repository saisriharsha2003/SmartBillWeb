<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">	
		<link rel="stylesheet" href="../style.css">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
		<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="icon" href="../assets/icon.png" type="image/icon type">
	    <title>Admin Add Bill</title>
	   
	</head>
	<body>
	<div class="hero">
	      <nav>
	          <a href="../admin_home.jsp"><img class="logo"
	                src="../assets/logo.png"></a>
	          <ul>
	            <li><a href="admin_home.jsp">Home</a></li>
	            <li><a href="/SmartBillWeb/AdminViewConsumers">View Consumers</a></li>
	            <li><a href="admin_addbill.jsp">Add Bills</a></li>
	            <li><a href="/SmartBillWeb/AdminViewBills">View Bills</a></li>	            
	            <li><a href="/SmartBillWeb/AdminViewComplaints">View Complaints</a></li>
	          </ul>
	          <img src="../assets/user.png" class="user-pic" onclick="toggleMenu()">
	          <div class="sub-menu-wrap" id="subMenu">
	       		<div class="sub-menu">
	        	<div class="user-info">
	        		<img src="../assets/user.png" style="width: 80px; height: 80px">
	        		<h2 id="acu_name" style="color:#CCBA78;"></h2>
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
	      <div class="signup">
	        <div class="container">
	         <div class='title' style="font-size: 25px">Add Bill</div>
	         <form id="my_login_form" action="<%=request.getContextPath()%>/AdminAddBill" method = "post">
	            <div class="user-details">
	              <div class="input-box">
	                <span class="details" style="color:black;">Consumer Number</span>
	                
	                <input type="text" id='abillcn' placeholder="Enter your Consumer Number"
	                  name="adbillcn" required
	                  oninvalid="this.setCustomValidity('Please Enter Consumer Number')"
	                  onchange="this.setCustomValidity('')">
	              </div>
	              <div class="input-box">
	                <span class="details" style="color:black;">Amount</span>
	                <input type="text" id="adamt" name = "adamt" required
	                  placeholder="Enter Amount to be paid"
	                  oninvalid="this.setCustomValidity('Please Enter Amount')"
	                  onchange="this.setCustomValidity('')"> 
	                  
	              </div>
	              <div class="input-box" style="color:black;">
	                <span class="details">Due Date</span>
	                <input type="date" id="addd" name = "addd"
	                  placeholder="Enter Due Date" required
	                  oninvalid="this.setCustomValidity('Enter Due Date')"
	                  onchange="this.setCustomValidity('')"
	                  >
	              </div>
	              
	            </div>
	            <div class="sbutton">
	              <input type="submit" id="aButton" value="Add Bill" style = "cursor: pointer">
	              <span class="lmessage1" id='llogin_message'></span>
	            </div>
	            
	          </form>
	        </div>
	        </div>
		</div>
		</body>
		<script>
			flatpickr("input[type=date]", {dateFormat: "d-m-Y",});
			var aname = document.getElementById("acu_name");
	    	aname.textContent = "Admin";
		</script>
		<script src="../scripts/script.js"></script>
</html>