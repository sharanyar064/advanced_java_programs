Read all the existing records from the table coffee which is from the database test and update an 
existing coffee product  in the table with its id. [Create a table coffee with fields 
( id,coffee_name,price)] using HTML and JSP to get the fields and display the results respectively



<%@ page import="java.sql.*" %>
<html>
<head><title>All Coffee Records</title></head>
<body>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Coffee Name</th>
        <th>Price</th>
    </tr>
<%
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        stmt = con.createStatement();
        rs = stmt.executeQuery("SELECT * FROM coffee");

        while (rs.next()) {
%>
    <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getString("coffee_name") %></td>
        <td><%= rs.getDouble("price") %></td>
    </tr>
<%
        }
    } catch (Exception e) {
        out.println("<tr><td colspan='3'>Error: " + e.getMessage() + "</td></tr>");
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (stmt != null) stmt.close(); } catch (Exception e) {}
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
%>
</table>
</body>
</html>
