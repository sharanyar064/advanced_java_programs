<%@ page import="java.sql.*" %>
<%
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "");

        String query = "SELECT * FROM Emp";
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
%>
<html>
<head>
    <title>Salary Report</title>
</head>
<body>
    <h2>Salary Report</h2>
    <%
        while(rs.next()) {
    %>
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br>
        Emp_No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <%= rs.getInt("empno") %><br>
        Emp_Name: <%= rs.getString("empname") %><br>
        Basic&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <%= rs.getDouble("basicsalary") %><br>
        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~<br><br>
    <%
        }
    %>
</body>
</html>
<%
    } catch(Exception e) {
        out.println("Error: " + e.getMessage());
    } finally {
        if(rs != null) rs.close();
        if(stmt != null) stmt.close();
        if(con != null) con.close();
    }
%>
