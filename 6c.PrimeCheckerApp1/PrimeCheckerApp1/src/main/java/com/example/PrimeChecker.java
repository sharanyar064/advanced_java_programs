package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/PrimeChecker")
public class PrimeChecker extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String numberStr = request.getParameter("number");

        try {
            int number = Integer.parseInt(numberStr);
            boolean isPrime = true;

            if (number <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            out.println("<html><body>");
            out.println("<h2>Result</h2>");
            out.println("<p>The number <strong>" + number + "</strong> is " + 
                (isPrime ? "<span style='color:green;'>a Prime</span>" : "<span style='color:red;'>not a Prime</span>") + " number.</p>");
            out.println("<a href='index.html'>Check Another</a>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            out.println("<p>Invalid number format.</p>");
        }
    }
}
