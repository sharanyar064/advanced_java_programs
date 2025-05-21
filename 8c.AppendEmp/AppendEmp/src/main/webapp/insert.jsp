 Develop a JDBC project using JSP to append  the fields empno,  empname and basicsalary 
into the table Emp of the database Employee by getting the fields  through keyboard and 
Generate the report as follows for the  TABLE Emp (Emp_NO , Emp_Name, Basicsalary ) using 
HTML and JSP to get the fields and display the results respectively



<%@ page import="java.sql.*" %>
<%
    String empno = request.getParameter("empno");
    String empname = request.getParameter("empname");
    String basicsalary = request.getParameter("basicsalary");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "");
        PreparedStatement ps = con.prepareStatement("INSERT INTO Emp VALUES (?, ?, ?)");
        ps.setInt(1, Integer.parseInt(empno));
        ps.setString(2, empname);
        ps.setDouble(3, Double.parseDouble(basicsalary));
        int i = ps.executeUpdate();

        if (i > 0) {
            out.println("<h3>Employee inserted successfully!</h3>");
        } else {
            out.println("<h3>Error inserting employee!</h3>");
        }

        con.close();
    } catch (Exception e) {
        out.println("Error: " + e.getMessage());
    }
%>
<br/>
<a href="index.html">Go Back</a>
