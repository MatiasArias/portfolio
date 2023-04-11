package org.mobydigital.marias.servlet.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    final static String USERNAME="MatiasArias";
    final static String PASSWORD="2313";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if((username.equals(USERNAME)&password.equals(PASSWORD))){
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();

            out.println("<!DOCTYPE html>");
            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Bienvenido, "+username+"!</h1>");
            out.println("</body>");
            out.println("</html>");
            out.close();
        }else{
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Usuario no autorizado");
        }

    }
}
