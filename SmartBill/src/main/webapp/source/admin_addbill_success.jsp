<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <link rel="stylesheet" href="../style.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
	<script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" href="../assets/icon.png" type="image/icon type">
    <title>Bill Details Added</title>
    
  </head>
  <body>
    <div>
      <div class="hero">
        <nav>
	          <a href="../admin_home.jsp"><img class="logo"
	                src="../assets/logo.png"></a>
	          <ul>
	            <li><a href="admin_home.jsp">Home</a></li>
	            <li><a href="${pageContext.request.contextPath}/AdminViewConsumers">View Consumers</a></li>
	            <li><a href="admin_addbill.jsp">Add Bills</a></li>
	            <li><a href="/SmartBillWeb/AdminViewBills">View Bills</a></li>	            	            
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
        <div class="container">
          <div class='title' style="font-size: 25px; color: #008000"">Bill Details Added Successfully!</div>
          <div class='details-cont'>
            <table>
              <tbody>
                <tr>
                  <td><span class='cust'>Consumer Number</span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='adbill_cn'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'> Bill Number </span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='adbill_bn'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'> Payable Amount</span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='adbill_amt'></span></td>
                </tr>
                <tr>
                  <td><span class='cust'> Due Date</span></td>
                  <td><span class='col'>:</span><span class='cust1'
                      id='adbill_due'></span></td>
                </tr>
                
              </tbody>
            </table>
          </div>
          <div class="sbutton">
            <input type="submit" id="bButton" value="Back to Home" style = "cursor:pointer"
              onclick="window.location='admin_home.jsp';">
          </div>
        </div>
      </div>
    </div>
    <script type="text/javascript">
	    let subm = document.getElementById("subMenu");
	    function toggleMenu() {
	    	subm.classList.toggle("open-menu");
	    }
	    
	    var aname = document.getElementById("acu_name");
    	aname.textContent = "Admin"
    
        var cn1 = document.getElementById("adbill_bn");
        var cn2 = document.getElementById("adbill_cn");
        var cn3 = document.getElementById("adbill_amt");
        var cn4 = document.getElementById("adbill_due");

        
        var bn = '<%= (session.getAttribute("addbill_bn") != null) ? session.getAttribute("addbill_bn").toString() : "" %>';
        var cn = '<%= (session.getAttribute("addbill_cn") != null) ? session.getAttribute("addbill_cn") : "" %>';
        var amt = '<%= (session.getAttribute("adbill_amt") != null) ? session.getAttribute("adbill_amt") : "" %>';
        var due = '<%= (session.getAttribute("adbill_date") != null) ? session.getAttribute("adbill_date") : "" %>';

        if (cn1) cn1.textContent = bn;
        if (cn2) cn2.textContent = cn;
        if (cn3) cn3.textContent = amt;
        if (cn4) cn4.textContent = due;

    </script>
  </body>
</html>