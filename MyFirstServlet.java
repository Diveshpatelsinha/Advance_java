package com.myapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;




@WebServlet("/greet")
public class GreetServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        if (name == null) {
            out.println("<h1> Hello Stranger</h1>");

        }else{
            out.println("<h1> Hello " +name+"!</h1>");
        }
    }
    // runs when a form submits to /greet with method="POST"

    protected void doPost(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String name = request.getParameter("name");
        response.getWriter().println("<h1>You submitted: " + name + "</h1>");
    }

}
