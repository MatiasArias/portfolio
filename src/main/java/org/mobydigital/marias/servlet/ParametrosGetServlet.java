package org.mobydigital.marias.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/parametros/url-get")
public class ParametrosGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String puesto = req.getParameter("puesto");
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Matias Jesús Arias</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>MATIAS JESÚS ARIAS</h1>");
        out.println("<h2>"+puesto+"</h2>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
