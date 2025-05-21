Read all the existing records from the table coffee which is from the database test and update an 
existing coffee product  in the table with its id. [Create a table coffee with fields 
( id,coffee_name,price)] using HTML and JSP to get the fields and display the results respectively

<%@ page import="java.sql.*" %>
<%
    String idStr = request.getParameter("id");
    String coffeeName = request.getParameter("coffee_name");
    String priceStr = request.getParameter("price");

    int id = Integer.parseInt(idStr);
    double price = Double.parseDouble(priceStr);

    Connection con = null;
    PreparedStatement ps = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

        String sql = "UPDATE coffee SET coffee_name=?, price=? WHERE id=?";
        ps = con.prepareStatement(sql);
        ps.setString(1, coffeeName);
        ps.setDouble(2, price);
        ps.setInt(3, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            out.println("<p style='color:green;'>Record updated successfully!</p>");
        } else {
            out.println("<p style='color:red;'>Record not found.</p>");
        }
    } catch (Exception e) {
        out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
    } finally {
        try { if (ps != null) ps.close(); } catch (Exception e) {}
        try { if (con != null) con.close(); } catch (Exception e) {}
    }
%>
<a href="index.html">Go Back</a>
