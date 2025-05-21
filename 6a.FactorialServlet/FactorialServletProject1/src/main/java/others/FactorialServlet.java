// Q: Build a servlet program to find the factorial of a number using HTML with step by step procedure.

package others;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/FactorialServlet")
public class FactorialServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // User-defined factorial method
    public long factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int number = Integer.parseInt(request.getParameter("number"));
        long result = factorial(number);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>Factorial of " + number + " is: " + result + "</h2>");
    }
}
