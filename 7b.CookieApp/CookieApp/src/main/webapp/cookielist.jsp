<%@ page import="javax.servlet.http.Cookie" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Active Cookies</title>
</head>
<body>
    <h2>List of Active Cookies</h2>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
%>
            <p>
                <strong>Name:</strong> <%= c.getName() %><br/>
                <strong>Value:</strong> <%= c.getValue() %><br/>
                <strong>Max Age:</strong> <%= c.getMaxAge() %> seconds<br/>
                <strong>Domain:</strong> <%= (c.getDomain() != null) ? c.getDomain() : "Default/Browser-Controlled" %>
            </p>
            <hr/>
<%
        }
    } else {
%>
        <p>No cookies found.</p>
<%
    }
%>
    <a href="index.html">Add another cookie</a>
</body>
</html>
