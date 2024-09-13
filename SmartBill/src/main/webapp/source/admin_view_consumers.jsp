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
		<title>View All Consumers</title>
	
	</head>
	<body>
	
		<div class="hero">
			<nav>
	          <a href="../admin_home.jsp"><img class="logo"
	                src="../assets/logo.png"></a>
	          <ul>
	            <li><a href="admin_home.jsp">Home</a></li>
	            <li><a href="${pageContext.request.contextPath}/AdminViewConsumers">View Consumers</a></li>
	            <li><a href="admin_addbill.jsp">Add Bills</a></li>
	            <li><a href="${pageContext.request.contextPath}/AdminViewBills">View Bills</a></li>	            
	            <li><a href="${pageContext.request.contextPath}/AdminViewComplaints">View Complaints</a></li>
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
		</div>
		<div class="signup">
			<div class="container1" >
				<div class="title" style="margin-bottom: 20px;">View Consumers </div>
				<div style="display: flex; justify-content: center;">
					<table class = "paybill">
				        <thead>
				            <tr>
				                <th>Consumer ID</th>
				                <th>Name</th>
				                <th>Mobile</th>
				                <th>Email</th>
				                <th>Username</th>
				            </tr>
				        </thead>
				        <tbody>
			            	<%
								List<HashMap<String, String>> l1 = (List<HashMap<String, String>>)session.getAttribute("admin_consumers");
			   					
				            	if (l1 != null) {
				                    for (HashMap<String, String> complaint : l1) {
								
							%>
			                <tr>
			                    <td><%= complaint.get("consumer_id") %></td>
			                    <td><%= complaint.get("consumer_name") %></td>
			                    <td><%= complaint.get("mobile") %></td>
			                    <td><%= complaint.get("email") %></td>
			                    <td><%= complaint.get("user_name") %></td>
			                </tr>
			            	<%
				                    }
				                }
				            %>
		        	</tbody>
		    	</table>
		    	</div>
			</div>
		</div>
	</body>
	<script src="../scripts/script.js"></script>
	<script>
	
	var name = '<%= (session.getAttribute("consumer_lgname") != null) ? session.getAttribute("consumer_lgname") : "" %>';
	var c1 = document.getElementById("acu_name");
	console.log(c1);
	console.log('<%= l1%>');
	if(c1) c1.textContent = name;		
	
	</script>
	
</html>