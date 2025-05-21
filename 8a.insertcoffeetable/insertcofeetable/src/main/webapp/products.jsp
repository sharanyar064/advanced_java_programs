<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<%
    String name = request.getParameter("product_name");
    String priceStr = request.getParameter("price");

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb", "root", "");

        // Insert product if parameters are provided
        if (name != null && priceStr != null && !name.isEmpty() && !priceStr.isEmpty()) {
            double price = Double.parseDouble(priceStr);
            String insertQuery = "INSERT INTO products (product_name, price) VALUES (?, ?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.executeUpdate();
            pstmt.close();
        }

        // Display all records
        String selectQuery = "SELECT * FROM products";
        pstmt = conn.prepareStatement(selectQuery);
        rs = pstmt.executeQuery();
%>

<h2>All Products</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Product Name</th>
        <th>Price</th>
    </tr>
<%
        while (rs.next()) {
%>
    <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getString("product_name") %></td>
        <td><%= rs.getDouble("price") %></td>
    </tr>
<%
        }
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    } finally {
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }
%>
</table>
</body>
</html>
