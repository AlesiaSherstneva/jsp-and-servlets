package com.luv2code.servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestParamServlet", value = "/TestParamServlet")
public class TestParamServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        ServletContext context = getServletContext();
        String maxCardSize = context.getInitParameter("max-shopping-cart-size");
        String teamName = context.getInitParameter("project-team-name");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("Max cart: " + maxCardSize);
        out.println("<br/><br/>");
        out.println("Team name: " + teamName);
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}