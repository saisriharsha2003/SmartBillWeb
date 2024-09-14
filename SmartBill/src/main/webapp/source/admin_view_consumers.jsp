<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
    <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" href="<%=request.getContextPath()%>/assets/icon.png" type="image/icon type">
    <title>View All Consumers</title>
</head>
<body>

    <div class="hero">
        <nav>
            <a href="<%=request.getContextPath()%>/admin_home.jsp"><img class="logo" src="<%=request.getContextPath()%>/assets/logo.png"></a>
            <ul>
                <li><a href="admin_home.jsp">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/AdminViewConsumers">View Consumers</a></li>
                <li><a href="admin_addbill.jsp">Add Bills</a></li>
                <li><a href="${pageContext.request.contextPath}/AdminViewBills">View Bills</a></li>
                <li><a href="${pageContext.request.contextPath}/AdminViewComplaints">View Complaints</a></li>
            </ul>
            <img src="<%=request.getContextPath()%>/assets/user.png" class="user-pic" onclick="toggleMenu()">
            <div class="sub-menu-wrap" id="subMenu">
                <div class="sub-menu">
                    <div class="user-info">
                        <img src="<%=request.getContextPath()%>/assets/user.png" style="width: 80px; height: 80px">
                        <h2 id="acu_name" style="color:#CCBA78;"></h2>
                    </div>
                    <hr>
                    <a href="#" class="sub-menu-link">
                        <img src="<%=request.getContextPath()%>/assets/edit.png" style="width: 50px; height: 50px">
                        <p>Edit Profile</p>
                        <span class="ext">></span>
                    </a>
                    <a href="login.jsp" class="sub-menu-link">
                        <img src="<%=request.getContextPath()%>/assets/logout.png" style="width: 50px; height: 50px">
                        <p>Logout</p>
                        <span class="ext">></span>
                    </a>
                </div>
            </div>  
        </nav>
    </div>

    <div class="signup">
        <div class="container1">
            <div class="title" style="margin-bottom: 20px;">View Consumers</div>
            <div style="display: flex; justify-content: center;">
                <table class="paybill">
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
                        List<HashMap<String, String>> consumersList = (List<HashMap<String, String>>) session.getAttribute("admin_consumers");

                        int currentPage = 1;
                        int recordsPerPage = 5;
                        int totalRecords = 0;

                        if (consumersList != null) {
                            totalRecords = consumersList.size();

                            if (request.getParameter("page") != null) {
                                currentPage = Integer.parseInt(request.getParameter("page"));
                            }

                            int start = (currentPage - 1) * recordsPerPage;
                            int end = Math.min(start + recordsPerPage, totalRecords);
                            List<HashMap<String, String>> paginatedConsumers = consumersList.subList(start, end);

                            for (HashMap<String, String> consumer : paginatedConsumers) {
                        %>
                        <tr>
                            <td><%= consumer.get("consumer_id") %></td>
                            <td><%= consumer.get("consumer_name") %></td>
                            <td><%= consumer.get("mobile") %></td>
                            <td><%= consumer.get("email") %></td>
                            <td><%= consumer.get("user_name") %></td>
                        </tr>
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
                    <a href="admin_view_consumers.jsp?page=<%= currentPage - 1 %>">&laquo; Previous</a>
                <%
                }
                for (int i = 1; i <= totalPages; i++) {
                    if (i == currentPage) {
                %>
                    <span><%= i %></span>
                <%
                    } else {
                %>
                    <a href="admin_view_consumers.jsp?page=<%= i %>"><%= i %></a>
                <%
                    }
                }
                if (currentPage < totalPages) {
                %>
                    <a href="admin_view_consumers.jsp?page=<%= currentPage + 1 %>">Next &raquo;</a>
                <%
                }
                %>
            </div>
        </div>
    </div>

    <script src="<%=request.getContextPath()%>/scripts/script.js"></script>
    <script>
        var name = '<%= (session.getAttribute("consumer_lgname") != null) ? session.getAttribute("consumer_lgname") : "" %>';
        var c1 = document.getElementById("acu_name");

        if(c1) c1.textContent = name;
    </script>
</body>
</html>
