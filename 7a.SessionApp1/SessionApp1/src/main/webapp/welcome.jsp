<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Welcome Page</title>
</head>
<body>
<%
    String name = request.getParameter("uname");

    // Display user name
    out.print("Welcome! " + name);
    out.print("<br>Session has started...");

    // Store in session
    session.setAttribute("user", name);

    out.print("<br>Your name has been stored in session object");

    // Set session expiry to 60 seconds
    session.setMaxInactiveInterval(60);
    out.print("<br>One minute is set for the session expiry");

    out.print("<br><br>Kindly press the following link after some time to check it:");
%>
    <br/><a href="second.jsp">Display the value</a>
</body>
</html>
