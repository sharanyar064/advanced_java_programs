<%@ page import="java.sql.*" %>

<h2>Employee Salary Report</h2>
<table border="1" cellpadding="8">
    <tr>
        <th>Emp No</th>
        <th>Emp Name</th>
        <th>Basic Salary</th>
    </tr>

<%
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "");

        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM Emp");

        while(rs.next()) {
%>
    <tr>
        <td><%= rs.getInt("empno") %></td>
        <td><%= rs.getString("empname") %></td>
        <td><%= rs.getDouble("basicsalary") %></td>
    </tr>
<%
        }
    } catch(Exception e) {
%>
        <tr><td colspan="3">Error: <%= e.getMessage() %></td></tr>
<%
    } finally {
        if(rs != null) rs.close();
        if(stmt != null) stmt.close();
        if(conn != null) conn.close();
    }
%>
</table>
<a href="index.html">Back to Entry</a>
