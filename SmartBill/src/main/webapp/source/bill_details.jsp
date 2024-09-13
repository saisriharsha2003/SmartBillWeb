<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" href="../assets/icon.png" type="image/icon type">
<title>View Bills</title>

</head>
<body>

	<div class="hero">
		<nav> <a href="../home.jsp"><img class="logo"
			src="../assets/logo.png"></a>
		<ul>
			<li><a href="home.jsp">Home</a></li>

			<li class="dropdown"><a href="#" class="dropbtn">Bill</a>
				<div class="dropdown-content">
					<a href="${pageContext.request.contextPath}/PayBills">Pay Bills</a> 
					<a	href="${pageContext.request.contextPath}/ViewBills">View Bills</a>
					<a href="${pageContext.request.contextPath}/SearchBills">Search
						Bill</a>
				</div></li>

			<li class="dropdown"><a href="#" class="dropbtn">Complaint</a>
				<div class="dropdown-content">
					<a href="register_complaint.jsp">Register Complaint</a> <a
						href="search_complaint.jsp">Search Complaint</a> <a
						href="${pageContext.request.contextPath}/ComplaintStatus">Complaint
						Status</a>
				</div></li>

			<li class="dropdown"><a href="#" class="dropbtn">Payments</a>
				<div class="dropdown-content">
					<a href="">Payments History</a> 
					<a href="">Search Payment Details</a>
				</div>
			</li>

		</ul>

		<img src="../assets/user.png" class="user-pic" onclick="toggleMenu()">
		<div class="sub-menu-wrap" id="subMenu">
			<div class="sub-menu">
				<div class="user-info">
					<img src="../assets/user.png" style="width: 80px; height: 80px">
					<h2 id="cu_name" style="color: #CCBA78;"></h2>
				</div>
				<hr>
				<a href="edit_profile.jsp" class="sub-menu-link"> <img
					src="../assets/edit.png" style="width: 50px; height: 50px">
					<p>Edit Profile</p> <span class="ext">></span>
				</a> <a href="login.jsp" class="sub-menu-link"> <img
					src="../assets/logout.png" style="width: 50px; height: 50px">
					<p>Logout</p> <span class="ext">></span>
				</a>
			</div>
		</div>
	</nav>
	</div>
	<div class="signup">
		<div class="container" style="padding: 15px 15px; width: 1000px;">
		<form>
		         <div class='title' style="font-size: 30px">Bill Payment</div>
		         <div style="display: flex; justify-content: center">
		         <%
		         	HashMap<String, String> hm=(HashMap<String, String>) session.getAttribute("payment_billdet");
		         	String det_bno = hm.get("bill_id");
		         	String det_bamt = hm.get("bill_amt");
		         	String det_conid = hm.get("cons_id");
		         	System.out.println(det_bamt+""+det_bno);
		         %>
	        	<table class="paybilldet" >
	        		<thead style="height: 15px; padding: 10px;">
	        			<tr >
	        			<th colspan = 2>Bill Details</th>
	        				
	        			</tr>
	        		</thead>
	        		<tbody>
	        			<tr>
	        				<td style="text-align: left;">Bill Amount</td>
	        				<td id="billdet_amt"></td>
	        				
	        			</tr>
	        			<tr>
	        				<td style="text-align: left;">Enter Amount to be paid</td>
	        				<td>
		        				<div class="user-details" >
		              				<div class="input-box" style="width: 40%; margin-left: 100px;">
	        							<input type="text" placeholder="Enter amount " id="billdet_pamt" name="billdet_pamt" required
				                  oninvalid="this.setCustomValidity('Please Enter Amount to proceed')"
				                  onchange="this.setCustomValidity('')" onkeyup="setValue()"  >
	        						</div>
	        					</div>
	        				</td>
	        			</tr>
	        			<tr>
	        				<td style="text-align: left;">PG Charge</td>
	        				<td>As Applicable
	        				</td>
	        				
	        			</tr>
	        		</tbody>
	        	</table>
	        	</div>
	        	<div style="display: flex; justify-content: center; margin-top: 20px; margin-bottom: 20px;">
	        	<table class="paybilldet" >
	        		<thead>
	        			<th>Customer Number</th>
	        			<th>Bill Number</th>
	        			<th>Payable Amount</th>
	        		</thead>
	        		<tbody>
	        		<tr>
	        			<td id="billdet_cno"></td>
	        			<td id="billdet_bno"></td>
	        			<td ><input type="text" id="bill_pamt" style="border-style: none; width: 40%; margin-left: 20px;"></td>
	        		</tr>
	        		</tbody>
	        	</table>
	        	
	        	</div>
	        	<div style="display: flex; justify-content: left; align-items: center; margin-left: 35px;">
		        	<img src="../assets/payment.jpg" style="width: 50px; height: 50px;">
		        	<p style="font-size: 20px; font-weight: 550; color:  #CCBA78;">Kindly select your mode of payment</p>
	        	</div>
	        	<div style="padding-left: 47px;"><hr style="border: 1px solid black; width: 50%; margin-top: 10px; "></div>
	        	<div style="display: flex; justify-content: center;">
	        	<div style="padding: 10px;">
		        	 <input type="radio" name="groupName">
		        	 <label>Credit Card</label>
	        	</div>
	        	 
	        	 <div style="padding: 10px;">
		        	 <input type="radio" name="groupName">
		        	 <label>Debit Card</label>
	        	</div>
	        	</div>
	        	<div class="flexcenter">
	        	<div class="flexcenter" style="width: 80%">
	        		<div class="sbutton" style="width:60%; padding:10px;">
	              		<input type="submit" id="aButton" value="Back to Home" style="cursor: pointer; " onclick="window.location.href='home.html'">
	              	</div>
		        	<div class="sbutton" style="width:60%; padding:10px;">
	              		<input type="submit" id="aButton" value="Pay Now" style="cursor: pointer; " onclick="window.location.href='pay_screen.html'">
	              	</div>	
              	</div>
              	</div>
	        </div>
	      </form>
	        
	</div>
</body>
<script src="../scripts/script.js"></script>
<script>



	if(document.getElementById("cu_name"))
	{
		var name = '<%=(session.getAttribute("consumer_lgname") != null) ? session.getAttribute("consumer_lgname") : ""%>';
		var c1 = document.getElementById("cu_name");
		if (c1)
			c1.textContent = name;
	}
	
	var n1 = document.getElementById("billdet_amt");
	var n2 = document.getElementById("billdet_pamt");
	var n3 = document.getElementById("billdet_cno");
	var n4 = document.getElementById("billdet_bno");
	var n5 = document.getElementById("bill_pamt");
	setValue();
	function setValue()
	{
		n5.value = n2.value;
		}
	n4.textContent = <%= det_bno %> 
	n1.textContent = <%= det_bamt %>
	n3.textContent = <%= det_conid %>
	n5.textContent = n2.value;

</script>

</html>