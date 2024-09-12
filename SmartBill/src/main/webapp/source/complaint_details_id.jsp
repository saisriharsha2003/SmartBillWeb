<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" href="../assets/icon.png" type="image/icon type">
    <title>Search Complaint</title>
    
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
			<li><a href="<%= request.getContextPath() %>/ComplaintStatus">Complaint Status</a></li>
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
          <div class='title' style="font-size: 25px; color: #CCBA78">Your Complaint Details</div>
          <div class='details-cont'>
            <table>
              <tbody>
                <tr>
                  <td><span class='cust'> Complaint ID </span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='fcompid'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'> Contact Person </span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='fcompper'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'> Status </span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='fcompstatus'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'> Mobile Number </span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='fcompmob'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'> Problem </span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='fcomprob'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'> Address </span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='fcompaddr'></span></td>
                </tr>
                
                
              </tbody>
            </table>
          </div>
         
       	<div class="sbutton" style="width:100%;">
           	<input type="submit" id="bButton" value="Back to Home" style="cursor:pointer" onclick="window.location='home.jsp';">
        </div>	
     
          
        </div>
      </div>
    </div>
    <%
    	HashMap<String, String> m1 = (HashMap<String, String>)session.getAttribute("search_complaint_id");
    	String p1 = m1.get("complaint_id");
    	String p2 = m1.get("contact_person");
    	String p3 = m1.get("mobile");
    	String p4 = m1.get("problem");
    	String p5 = m1.get("address");
    	String p6 = m1.get("status");
    %>
    <script type="text/javascript">
	   var cn1 = document.getElementById("fcompid");
	   var cn2 = document.getElementById("fcompper");
	   var cn3 = document.getElementById("fcompmob");
	   var cn4 = document.getElementById("fcomprob");  
	   var cn5 = document.getElementById("fcompaddr");
	   var cn6 = document.getElementById("fcompstatus");  
	
	   var n1 = "<%= p1 %>";
	   if (cn1) cn1.textContent = n1;
	   if (cn2) cn2.textContent = "<%= p2 %>";
	   if (cn3) cn3.textContent = "<%= p3 %>";
	   if (cn4) cn4.textContent = "<%= p4 %>";
	   if (cn5) cn5.textContent = "<%= p5 %>";
	   if (cn6) cn6.textContent = "<%= p6 %>";

    </script>
  </body>
</html>