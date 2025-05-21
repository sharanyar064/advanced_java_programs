<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>All Coffee Records</title></head>
<body>
    <h2>All Coffee Records</h2>
    <%
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = ""; // change accordingly

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM coffee");
    %>
    <table border="1">
        <tr><th>ID</th><th>Coffee Name</th><th>Price</th></tr>
        <%
            while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("id") %></td>
            <td><%= rs.getString("coffee_name") %></td>
            <td><%= rs.getDouble("price") %></td>
        </tr>
        <%
            }
            rs.close(); stmt.close(); con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
        %>
    </table>
</body>
</html>
