<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Coffees Starting with 'D'</title></head>
<body>
    <h2>Coffees Starting with 'D'</h2>
    <%
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = ""; // change accordingly

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM coffee WHERE coffee_name LIKE 'D%'");
            ResultSet rs = ps.executeQuery();
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
            rs.close(); ps.close(); con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
        %>
    </table>
</body>
</html>
