<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.*,javax.servlet.http.*" %>

<%
    String empno = request.getParameter("empno");
    String empname = request.getParameter("empname");
    String basicsalary = request.getParameter("basicsalary");

    Connection conn = null;
    PreparedStatement ps = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "");

        String sql = "INSERT INTO Emp (empno, empname, basicsalary) VALUES (?, ?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(empno));
        ps.setString(2, empname);
        ps.setDouble(3, Double.parseDouble(basicsalary));
        ps.executeUpdate();
%>
        <h3>Record inserted successfully!</h3>
        <a href="report.jsp">View Employee Report</a>
<%
    } catch(Exception e) {
%>
        <p>Error: <%= e.getMessage() %></p>
<%
    } finally {
        if(ps != null) ps.close();
        if(conn != null) conn.close();
    }
%>
