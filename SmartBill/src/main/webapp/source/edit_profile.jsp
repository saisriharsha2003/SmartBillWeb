<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.* "%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../style.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" href="../assets/icon.png" type="image/icon type">
<title>Edit Profile</title>

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
			<div class="title" style="margin-bottom: 20px;">Edit Profile</div>
			<form name='myform'
				action="<%=request.getContextPath()%>/EditProfile" method="post">
				<div class="user-details">



					<div class="input-box">
						<span class="details">Full Name</span> <input type="text"
							name="edit-name" id='edit-name'>
					</div>
					<div class="input-box">
						<span class="details">Email</span> <input type="email"
							name="edit-email" id='edit-email'>
					</div>
					<div class="input-box">
						<span class="details">Mobile Number</span> <input type="text"
							id='edit-phno' name="edit-mobile">
					</div>

					<div class="input-box">
						<span class="details">Username</span> <input name="edit-uname"
							type="text" id='edit-uname'>
					</div>
					<div class="input-box">
						<span class="details">Password</span> <input type="password"
							id="edit-password" name="edit-password"
							pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
							title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
							onkeyup='edit_check();'>
					</div>
					<div class="input-box">
						<span class="details">Congfirm Password</span> <input
							type="password" id="edit-cpassword" name="edit-cpassword"
							pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
							title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
							onkeyup='edit_check();'>
							<span class="edit-message" id='edit-message'></span> 
					</div>
				</div>
				<div style="display: flex; justify-content: center;">
					<div class="sbutton" style="width: 50%; padding-right: 10px;">
						<input id="aButton" value="Back to Home"
							style="cursor: pointer; text-align: center"
							onclick="window.location='home.jsp'">
					</div>
					<div class="sbutton" style="width: 50%;">
						<input type="submit" id="up-Button" value="Update Profile"
							style="cursor: pointer;">
					</div>
				</div>

			</form>
		</div>

	</div>
</body>
<script src="../scripts/script.js"></script>
	<%
		HashMap<String, String> mp = (HashMap<String, String>) session.getAttribute("user-details");
		String name = mp.get("name");
		String pwd = mp.get("password");
		String uname = mp.get("username");
		String mobile = mp.get("mobile");
		String email = mp.get("email");
	%>
<script>
	var name = ' <%=(session.getAttribute("consumer_lgname") != null) ? session.getAttribute("consumer_lgname") : ""%> ' ;
	var c1 = document.getElementById("cu_name");
	if (c1) c1.textContent = name;
	
    var c1 = document.getElementById("edit-name");
    var c2 = document.getElementById("edit-email");
    var c3 = document.getElementById("edit-phno");
    var c4 = document.getElementById("edit-uname");
    var c5 = document.getElementById("edit-password");
    var c6 = document.getElementById("edit-cpassword");
    
    if(c1) c1.value = '<%=name%>';
	if(c2) c2.value = '<%=email%>';
    if(c3) c3.value = '<%=mobile%>';
   	if(c4) c4.value = '<%=uname%>';
    if(c5) c5.value= '<%=pwd%>';
    if(c6) c6.value =  '<%=pwd%>';
</script>
</html>