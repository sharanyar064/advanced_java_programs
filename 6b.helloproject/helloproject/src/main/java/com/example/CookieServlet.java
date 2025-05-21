package com.example;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.URLEncoder;
import java.net.URLDecoder;

public class CookieServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        boolean newVisitor = true;
        int visitCount = 1;
        String encodedUsername = URLEncoder.encode(username, "UTF-8");

        Cookie[] cookies = request.getCookies();
        String visitCountStr = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitCount")) {
                    visitCountStr = cookie.getValue();
                    newVisitor = false;
                }
            }
        }

        if (!newVisitor && visitCountStr != null) {
            try {
                visitCount = Integer.parseInt(visitCountStr) + 1;
            } catch (NumberFormatException e) {
                visitCount = 1;
            }
        }

        // Set cookies with encoded values
        Cookie nameCookie = new Cookie("username", encodedUsername);
        Cookie countCookie = new Cookie("visitCount", String.valueOf(visitCount));

        // Set expiry time in seconds (e.g., 30 seconds)
        nameCookie.setMaxAge(30);
        countCookie.setMaxAge(30);

        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        out.println("<html><body>");

        // Decode username for display
        String decodedUsername = URLDecoder.decode(encodedUsername, "UTF-8");
        out.println("<h2>Welcome back " + decodedUsername + "!</h2>");
        out.println("<p>You have visited this page " + visitCount + " times.</p>");
        out.println("<p>(Note: Cookies expire in 30 seconds.)</p>");

        out.println("</body></html>");
    }
}
