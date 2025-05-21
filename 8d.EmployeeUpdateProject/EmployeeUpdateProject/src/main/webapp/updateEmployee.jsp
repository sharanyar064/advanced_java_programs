<%@ page import="java.sql.*" %>
<%
    String empnoStr = request.getParameter("empno");
    String empname = request.getParameter("empname");
    String basicsalaryStr = request.getParameter("basicsalary");

    int empno = Integer.parseInt(empnoStr);
    double basicsalary = Double.parseDouble(basicsalaryStr);

    Connection conn = null;
    PreparedStatement pstmt = null;
    String message = "";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "");

        // Replace EmpNo with your actual column name
        String sql = "UPDATE Emp SET empname = ?, basicsalary = ? WHERE EmpNo = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, empname);
        pstmt.setDouble(2, basicsalary);
        pstmt.setInt(3, empno);

        int rowsUpdated = pstmt.executeUpdate();

        if (rowsUpdated > 0) {
            message = "Employee updated successfully!";
        } else {
            message = "No employee found with empno " + empno;
        }
    } catch (Exception e) {
        message = "Error: " + e.getMessage();
    } finally {
        try {
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception ex) {
            message += "<br>Error closing resources: " + ex.getMessage();
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Result</title>
</head>
<body>
    <h2><%= message %></h2>
    <a href="index.html">Back to Update Form</a>
</body>
</html>
