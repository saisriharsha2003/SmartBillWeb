<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="../style.css">
		<link rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="icon" href="../assets/icon.png" type="image/icon type">
		<title>View All Complaints</title>
	
	</head>
	<body>
	
		<div class="hero">
			<nav> <a href="../home.jsp"><img class="logo"
				src="../assets/logo.png"></a>
			<ul>
				<li><a href="home.jsp">Home</a></li>
				<li><a href="paybill.html">Pay Bill</a></li>
				<li><a href="register_complaint.jsp">Register Complaint</a></li>
				<li><a href="search_complaint.jsp">Search Complaint</a></li>
				<li><a href="/SmartBillWeb/ComplaintStatus">Complaint Status</a></li>
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
			<div class="container1">
				<div class="title" style="margin-bottom: 20px;">View All Complaints </div>
					<table class = "paybill">
				        <thead>
				            <tr>
				                <th>Complaint ID</th>
				                <th>Contact Person</th>
				                <th>Mobile</th>
				                <th>Problem</th>
				                <th>Address</th>
				                <th>Status</th>
				            </tr>
				        </thead>
				        <tbody>
			            	<%
								List<HashMap<String, String>> l1 = (List<HashMap<String, String>>)session.getAttribute("view_all_comp");
				            	if (l1 != null) {
				                    for (HashMap<String, String> complaint : l1) {
								
							%>
			                <tr>
			                    <td><%= complaint.get("complaint_id") %></td>
			                    <td><%= complaint.get("contact_person") %></td>
			                    <td><%= complaint.get("mobile") %></td>
			                    <td><%= complaint.get("problem") %></td>
			                    <td><%= complaint.get("address") %></td>
			                    <td><%= complaint.get("status") %></td>
			                </tr>
			            	<%
				                    }
				                }
				            %>
		        	</tbody>
		    	</table>
			</div>
		</div>
	</body>
	<script src="../scripts/script.js"></script>
	<script>
	if(document.getElementById("cu_name"))
	{
		var name = '<%= (session.getAttribute("consumer_lgname") != null) ? session.getAttribute("consumer_lgname") : "" %>';
		var c1 = document.getElementById("cu_name");
		if(c1) c1.textContent = name;		
	}
	</script>
	
</html>