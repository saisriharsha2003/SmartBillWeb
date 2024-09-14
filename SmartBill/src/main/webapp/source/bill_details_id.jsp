<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" href="<%=request.getContextPath()%>/assets/icon.png" type="image/icon type">
    <title>Bill Details By BillId</title>
    
  </head>
  <body>
    <div>
      <div class="hero">
        <nav> <a href="<%=request.getContextPath()%>/home.jsp"><img class="logo"
			src="<%=request.getContextPath()%>/assets/logo.png"></a>
		<ul>
			<li><a href="home.jsp">Home</a></li>

			<li class="dropdown"><a href="#" class="dropbtn">Bill</a>
				<div class="dropdown-content">
					<a href="${pageContext.request.contextPath}/PayBills">Pay Bills</a> 
					<a href="${pageContext.request.contextPath}/ViewBills">View Bills</a>
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
        <div class="container">
          <div class='title' style="font-size: 25px; color: #CCBA78">Your Bill Details</div>
          <div class='details-cont'>
            <table>
            <%
            HashMap<String, String> m1 = (HashMap<String, String>)session.getAttribute("search_bill_id");
    	    if (m1 != null) {
    	            String status = m1.get("status");
    	            String statusClass;
    	            switch (status.toLowerCase()) {
    	                case "unpaid":
    	                    statusClass = "status-unpaid";
    	                    break;
    	                case "partially paid":
    	                    statusClass = "status-partially-paid";
    	                    break;
    	                case "overdue":
    	                    statusClass = "status-overdue";
    	                    break;
    	                case "paid":
    	                default:
    	                    statusClass = "status-paid";
    	                    break;
    	     		}
            %>
              <tbody>
                <tr>
                  <td><span class='cust'> Bill ID </span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='scbbillid'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'> Due Amount </span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='scbdamt'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'> Bill Amount </span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='scbbamt'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'> Due Date </span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='scbddate'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'> Penalty </span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='scbpen'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'> Status </span></td>
                  <td><span class='col'>:</span><span class= "<%= statusClass %>" style="margin-left: 25px;"
                      id='scbst'></span></td>
                </tr>
                
                
              </tbody>
              <%
                      }
                  
              %>
            </table>
          </div>
         
       	<div class="sbutton" style="width:100%;">
           	<button type="submit" id="bButton" style="cursor:pointer" onclick="window.location='home.jsp';">Back to Home</button>
        </div>	
     
          
        </div>
      </div>
    </div>
    <%

    	String p1 = m1.get("bill_id");
    	String p2 = m1.get("due_amt");
    	String p3 = m1.get("bill_amt");
    	String p4 = m1.get("due_date");
    	String p5 = m1.get("penalty");
    	String p6 = m1.get("status");
    %>
    <script src="<%=request.getContextPath()%>/scripts/script.js"></script>
    <script type="text/javascript">
    	var name = '<%= (session.getAttribute("consumer_lgname") != null) ? session.getAttribute("consumer_lgname") : "" %>';
		var c6 = document.getElementById("cu_name");
		if(c6) c6.textContent = name;
		
	   var cn1 = document.getElementById("scbbillid");
	   var cn2 = document.getElementById("scbdamt");
	   var cn3 = document.getElementById("scbbamt");
	   var cn4 = document.getElementById("scbddate");  
	   var cn5 = document.getElementById("scbpen");
	   var cn6 = document.getElementById("scbst");  
	
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