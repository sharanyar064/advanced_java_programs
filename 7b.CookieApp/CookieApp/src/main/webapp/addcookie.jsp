<%@ page import="javax.servlet.http.Cookie" %>
<%
    String name = request.getParameter("cname");
    String domain = request.getParameter("cdomain");
    int expiry = Integer.parseInt(request.getParameter("expiry"));

    Cookie cookie = new Cookie(name, "CookieValue");
    cookie.setMaxAge(expiry);
    cookie.setPath("/");

    // Avoid setting domain as 'localhost' due to browser restrictions
    if (!domain.equalsIgnoreCase("localhost")) {
        cookie.setDomain(domain);
    }

    response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Cookie Set Page</title>
</head>
<body>
    <h2>Cookie has been added successfully!</h2>
    <p><strong>Name:</strong> <%= name %></p>
    <p><strong>Domain:</strong> <%= domain %></p>
    <p><strong>Max Age:</strong> <%= expiry %> seconds</p>

    <br>
    <a href="cookielist.jsp">Go to the active cookie list</a>
</body>
</html>
