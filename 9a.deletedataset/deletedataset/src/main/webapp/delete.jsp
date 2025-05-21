Read all the existing records from the table coffee which is from the database test and delete 
an existing coffee product  from the table with its id and display the rest of the records using 
HTML and JSP to get the field and display the results respectively


<%@ page import="java.sql.*" %>
<%
    String id = request.getParameter("id");

    if (id != null && !id.trim().equals("")) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            pstmt = conn.prepareStatement("DELETE FROM coffee WHERE id = ?");
            pstmt.setInt(1, Integer.parseInt(id));
            pstmt.executeUpdate();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        } finally {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        }
    }

    response.sendRedirect("index.jsp");
%>
