<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" href="../assets/icon.png" type="image/icon type">
    <title>View Bills</title>
    
</head>
<body>
    <div class="hero">
        <nav> 
            <a href="../home.jsp"><img class="logo" src="../assets/logo.png"></a>
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
                        <a href="">Payments History</a>
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
                    <a href="login.jsp" class="sub-menu-link">
                        <img src="../assets/logout.png" style="width: 50px; height: 50px">
                        <p>Logout</p> <span class="ext">></span>
                    </a>
                </div>
            </div>
        </nav>
    </div>
    <div class="signup">
        <div class="container1" style="width: 750px;">
            <div class="title" style="margin-bottom: 20px;">View All Bills</div>
            <div style="display: flex; justify-content: center;">
                <table class="paybill">
                    <thead>
                        <tr>
                            <th>Bill ID</th>
                            <th>Due Amount</th>
                            <th>Payable Amount</th>
                            <th>Due Date</th>
                            <th>Status</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        List<HashMap<String, String>> l1 = (List<HashMap<String, String>>) session.getAttribute("view_all_bills");
                        if (l1 != null) {
                            for (HashMap<String, String> bill : l1) {
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
                        <tr>
                            <td><%= bill.get("bill_id") %></td>
                            <td><%= bill.get("due_amt") %></td>
                            <td><%= bill.get("pay_amt") %></td>
                            <td><%= bill.get("date") %></td>
                            <td class="<%= statusClass %>"><%= bill.get("status") %></td>
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
    <script src="../scripts/script.js"></script>
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
