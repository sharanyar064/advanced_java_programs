Read all the existing records from the table coffee which is from the database test and delete 
an existing coffee product  from the table with its id and display the rest of the records using 
HTML and JSP to get the field and display the results respectively




<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Coffee List</title>
</head>
<body>
    <h2>All Coffee Products</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Coffee Name</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <%
            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT * FROM coffee");

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("coffee_name");
                    double price = rs.getDouble("price");
        %>
        <tr>
            <td><%= id %></td>
            <td><%= name %></td>
            <td><%= price %></td>
            <td><a href="delete.jsp?id=<%= id %>">Delete</a></td>
        </tr>
        <%
                }
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            } finally {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }
        %>
    </table>
</body>
</html>
