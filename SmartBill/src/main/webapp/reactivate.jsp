<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" href="<%=request.getContextPath()%>/assets/icon.png" type="image/icon type">
    <title>Reactivate Account</title>
</head>
<body>
    <div class="hero">
        <nav>
            <a href="<%= request.getContextPath() %>/index.jsp"><img class="logo" src="<%= request.getContextPath() %>/assets/logo.png" alt="Logo"></a>
            <ul>
                <li><a href="<%= request.getContextPath() %>/index.jsp">Home</a></li>
                <li><a href="about.jsp">About</a></li>
                <li><a href="contact.jsp">Contact</a></li>
                <li><button class="ind_button"><a class="b1" href="<%= request.getContextPath() %>/register.jsp">Register</a></button></li>
                <li><button class="ind_button"><a class="b1" href="<%= request.getContextPath() %>/login.jsp">Login</a></button></li>
            </ul>
        </nav>
    </div>
    <div class="signup">
        <div class="container" style="width: 800px;">
        	<div class="flexcenter" style="text-align: center; align-items: center; gap: 20px;">
                <img src="<%=request.getContextPath()%>/assets/reactivate.png" alt="Delete Emoji" style="height: 70px; width: 70px;">
                <p class="title1" style="font-size: 30px;">Reactivate Account</p>
            </div>
            
            <div class="flexcenter" style="align-items: center; width: 100%; text-align: center; margin-top: 20px;" >
            	<p style="font-size: 20px; font-weight: 600; texxt-align: center;">Your account has been deleted. Please click below to reactivate?</p>
            </div>
            <form action = "<%=request.getContextPath()%>/reactivate_login.jsp">
	            <div class="flexcenter">
	            	<div class="sbutton" style="width: 100%; padding: 20px; ">
						<button style="cursor: pointer; background: red;" onclick="window.location.href='home.jsp'">Cancel</button>
					</div>
					<div class="sbutton" style="width: 100% ; padding: 20px;">
						<button type="submit" style="cursor: pointer; background: green; onclick="window.location.href='<%=request.getContextPath()%>/reactivate_login.jsp'">Proceed</button>
					</div>
	            </div>
            </form>
        </div>
    </div>