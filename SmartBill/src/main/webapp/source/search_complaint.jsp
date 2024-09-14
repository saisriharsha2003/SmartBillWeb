<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" href="../assets/icon.png" type="image/icon type">
<title>Search Complaint</title>

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
				<a href="edit_profile.jsp" class="sub-menu-link"> 
					<img src="../assets/edit.png" style="width: 50px; height: 50px">
					<p>Edit Profile</p> <span class="ext">></span>
				</a> 
				<a href="delete_profile.jsp" class="sub-menu-link"> 
					<img src="../assets/delete.png" style="width: 50px; height: 50px">
					<p>Delete Account</p> <span class="ext">></span>
				</a> 
				<a href="login.jsp" class="sub-menu-link"> 
				<img src="../assets/logout.png" style="width: 50px; height: 50px">
					<p>Logout</p> <span class="ext">></span>
				</a>
			</div>
		</div>
	</nav>
	</div>
	<div class="signup">
		<div class="container">
			<div class="title" style="margin-bottom: 20px;">Search
				Complaint</div>
			<form class="complaint_status_form" action="<%=request.getContextPath()%>/SearchComplaint" method = "post">
				<span class="details" style="font-weight: 600">Complaint Number</span>
				<div class="user-details">

					<div class="input-box" style="width: 100%">
						<input type="text" class="searchi" name="search_compid"
							placeholder="Enter your Complaint Number" required
							oninvalid="this.setCustomValidity('Please Enter Complaint Number')"
							onchange="this.setCustomValidity('')">
						<button class="searchb">
							<i class="fa fa-search"></i>
						</button>
					</div>
				</div>
				<div class="sbutton">
					<input type="submit" id="aButton" value="Get Complaint Status" style="cursor: pointer">
				</div>
			</form>
			
		</div>
	</div>
</body>
</html>