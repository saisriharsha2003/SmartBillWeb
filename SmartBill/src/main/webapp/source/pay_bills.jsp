<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" href="<%=request.getContextPath()%>/assets/icon.png" type="image/icon type">
    <title>Pay Bills</title>
</head>
<body>
    <div class="hero">
        <nav>
            <a href="<%=request.getContextPath()%>/home.jsp"><img class="logo" src="<%=request.getContextPath()%>/assets/logo.png"></a>
            <ul>
                <li><a href="home.jsp">Home</a></li>
                <li class="dropdown">
                    <a href="#" class="dropbtn">Bill</a>
                    <div class="dropdown-content">
                        <a href="${pageContext.request.contextPath}/PayBills">Pay Bills</a>
                        <a href="${pageContext.request.contextPath}/ViewBills">View Bills</a>
                        <a href="${pageContext.request.contextPath}/SearchBills">Search Bill</a>
                    </div>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropbtn">Complaint</a>
                    <div class="dropdown-content">
                        <a href="register_complaint.jsp">Register Complaint</a>
                        <a href="search_complaint.jsp">Search Complaint</a>
                        <a href="${pageContext.request.contextPath}/ComplaintStatus">Complaint Status</a>
                    </div>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropbtn">Payments</a>
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
        <div class="container1" style="width: 900px;">
            <div class="title" style="margin-bottom: 20px;">Pay Bills</div>
            <div style="display: flex; justify-content: center;">
                <table class="paybill">
                    <thead>
                        <tr>
                            <th>Bill ID</th>
                            <th>Due Amount</th>
                            <th>Payable Amount</th>
                            <th>Due Date</th>
                            <th>Penalty</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        List<HashMap<String, String>> billList = (List<HashMap<String, String>>) session.getAttribute("view_all_bills");

                        int currentPage = 1;
                        int recordsPerPage = 4;
                        int totalRecords = 0;

                        if (billList != null) {
                            totalRecords = billList.size();

                            if (request.getParameter("page") != null) {
                                currentPage = Integer.parseInt(request.getParameter("page"));
                            }

                            int start = (currentPage - 1) * recordsPerPage;
                            int end = Math.min(start + recordsPerPage, totalRecords);
                            List<HashMap<String, String>> paginatedBills = billList.subList(start, end);

                            for (HashMap<String, String> bill : paginatedBills) {
                                String status = bill.get("status");
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
                        <form action="<%= request.getContextPath() %>/BillDetails" method="post">
                            <tr>
                                <td><%= bill.get("bill_id") %></td>
                                <td><%= bill.get("due_amt") %></td>
                                <td><%= bill.get("pay_amt") %></td>
                                <td><%= bill.get("date") %></td>
                                <td><%= bill.get("penalty") %></td>
                                <td class="<%= statusClass %>"><%= bill.get("status") %></td>
                                <td>
                                    
                                        <button type="submit" class="upbill" id="adstcmp" style="cursor: pointer">Pay</button>
                                    
                                </td>
                                <input type="hidden" name="up_bill" value="<%= bill.get("bill_id") %>">
                            </tr>
                        </form>
                        <%
                            }
                        }
                        %>
                    </tbody>
                </table>
            </div>

            <%
            int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
            %>
            <div class="pagination">
                <%
                if (currentPage > 1) {
                %>
                    <a href="pay_bills.jsp?page=<%= currentPage - 1 %>">&laquo; Previous</a>
                <%
                }
                for (int i = 1; i <= totalPages; i++) {
                    if (i == currentPage) {
                %>
                    <span><%= i %></span>
                <%
                    } else {
                %>
                    <a href="pay_bills.jsp?page=<%= i %>"><%= i %></a>
                <%
                    }
                }
                if (currentPage < totalPages) {
                %>
                    <a href="pay_bills.jsp?page=<%= currentPage + 1 %>">Next &raquo;</a>
                <%
                }
                %>
            </div>
        </div>
    </div>
    <script src="<%=request.getContextPath()%>/scripts/script.js"></script>
    <script>
        if(document.getElementById("cu_name")) {
            var name = '<%=(session.getAttribute("consumer_lgname") != null) ? session.getAttribute("consumer_lgname") : ""%>';
            var c1 = document.getElementById("cu_name");
            if (c1)
                c1.textContent = name;
        }
    </script>
</body>
</html>
