<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" href="<%=request.getContextPath()%>/assets/icon.png" type="image/icon type">
<title>Home</title>

</head>
<body>
	<div class="hero">
		<nav> <a href="<%=request.getContextPath()%>/home.jsp"><img class="logo"
			src="<%=request.getContextPath()%>/assets/logo.png"></a>
		<ul>
			<li><a href="home.jsp">Home</a></li>

			<li class="dropdown"><a href="#" class="dropbtn">Bill</a>
				<div class="dropdown-content">
					<a href="${pageContext.request.contextPath}/PayBills">Pay Bills</a> 
					<a	href="${pageContext.request.contextPath}/ViewBills">View Bills</a>
					<a href="search_bill.jsp">Search
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
					<a href="${pageContext.request.contextPath}/PaymentHistory">Payments History</a> 
					<a href="search_complaint.jsp">Search Payment Details</a>
				</div>
			</li>
		</ul>

		<img src="<%=request.getContextPath()%>/assets/user.png" class="user-pic" onclick="toggleMenu()">
		<div class="sub-menu-wrap" id="subMenu">
			<div class="sub-menu">
				<div class="user-info">
					<img src="<%=request.getContextPath()%>/assets/user.png" style="width: 80px; height: 80px">
					<h2 id="cu_name" style="color: #CCBA78;"></h2>
				</div>
				<hr>
				<a href="edit_profile.jsp" class="sub-menu-link"> 
					<img src="<%=request.getContextPath()%>/assets/edit.png" style="width: 50px; height: 50px">
					<p>Edit Profile</p> <span class="ext">></span>
				</a> 
				<a href="delete_profile.jsp" class="sub-menu-link"> 
					<img src="<%=request.getContextPath()%>/assets/delete.png" style="width: 50px; height: 50px">
					<p>Delete Account</p> <span class="ext">></span>
				</a> 
				<a href="<%=request.getContextPath()%>/login.jsp" class="sub-menu-link"> 
				<img src="<%=request.getContextPath()%>/assets/logout.png" style="width: 50px; height: 50px">
					<p>Logout</p> <span class="ext">></span>
				</a>
			</div>
		</div>
	</nav>

	</div>
	<div class="signup">
		<div class="container" style="background-color: black; opacity: 0.8;">
			<p
				style="font-size: 40px; font-weight: 600; color: #CCBA78; display: flex; justify-content: center; align-items: center">
				Welcome to <span class="homep">SmartBill</span>
			</p>
		</div>
	</div>
	<script src="<%=request.getContextPath()%>/scripts/script.js"></script>
	<script>
	var name = ' <%=(session.getAttribute("consumer_lgname") != null) ? session.getAttribute("consumer_lgname") : ""%> ' ;
	var c1 = document.getElementById("cu_name");
	if (c1) c1.textContent = name;
	</script>
</body>
</html>
</html>