<%@ page import="java.sql.*" %>
<%
    String prefix = request.getParameter("prefix");

    Connection con = null;
    PreparedStatement deleteStmt = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "");

        String deleteQuery = "DELETE FROM Emp WHERE empname LIKE ?";
        deleteStmt = con.prepareStatement(deleteQuery);
        deleteStmt.setString(1, prefix + "%");
        deleteStmt.executeUpdate();

        // Redirect to report.jsp
        response.sendRedirect("report.jsp");

    } catch(Exception e) {
        out.println("Error: " + e.getMessage());
    } finally {
        if(deleteStmt != null) deleteStmt.close();
        if(con != null) con.close();
    }
%>
